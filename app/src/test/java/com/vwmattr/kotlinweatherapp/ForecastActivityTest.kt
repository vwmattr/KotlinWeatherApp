package com.vwmattr.kotlinweatherapp

import android.support.v7.widget.RecyclerView
import com.nhaarman.mockito_kotlin.doNothing
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.vwmattr.kotlinweatherapp.domain.model.ForecastList
import com.vwmattr.kotlinweatherapp.robolectric.RobolectricHelper
import com.vwmattr.kotlinweatherapp.ui.ForecastView
import com.vwmattr.kotlinweatherapp.ui.activities.BaseActivity
import com.vwmattr.kotlinweatherapp.ui.activities.ForecastActivity
import com.vwmattr.kotlinweatherapp.ui.adapters.ForecastListAdapter
import com.vwmattr.kotlinweatherapp.ui.presenter.ForecastPresenter
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.mock
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config


/**
 * Unit tests for [ForecastActivity].
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(22))
class ForecastActivityTest {

    lateinit var activity : ForecastActivity
    lateinit var activityController : ActivityController<ForecastActivity>

    @Before
    fun setUp() {
        activityController = Robolectric.buildActivity(ForecastActivity::class.java)
        activity = RobolectricHelper.injectSpiedActivityBeforeOnCreate(activityController)
        doNothing().whenever(activity).injectActivity()
        activity.forecastList = mock(RecyclerView::class.java)
    }

    @Test
    fun shouldBeForecastView() {
        assertThat(activity).isInstanceOf(ForecastView::class.java)
    }

    @Test
    fun shouldBeBaseActivity() {
        assertThat(activity).isInstanceOf(BaseActivity::class.java)
    }

    @Test
    fun displayForecast() {
        //1) Arrange
        val forecastList : ForecastList = mock(ForecastList::class.java)

        //2) Act
        activity.displayForecast(forecastList)

        //3) Assert
        val captor : ArgumentCaptor<ForecastListAdapter> =
                ArgumentCaptor.forClass(ForecastListAdapter::class.java)
        verify(activity.forecastList).setAdapter(captor.capture())
        val adapter = captor.value
        assertThat(adapter.weekForecast).isEqualTo(forecastList)
    }

    @Test
    fun onStartShouldStartPresenting() {
        //1) Arrange
        activity.presenter = mock(ForecastPresenter::class.java)

        //2) Act
        activityController.create().start()

        //3) Assert
        verify(activity.presenter).startPresenting()
    }

    @Test
    fun onStopShouldStopPresenting() {
        //1) Arrange
        activity.presenter = mock(ForecastPresenter::class.java)

        //2) Act
        activityController.create().stop()

        //3) Assert
        verify(activity.presenter).stopPresenting()
    }

}