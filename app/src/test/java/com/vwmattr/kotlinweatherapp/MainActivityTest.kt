package com.vwmattr.kotlinweatherapp

import android.support.v7.widget.RecyclerView
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


/**
 * Unit tests for [MainActivity].
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(22))
class MainActivityTest {

    @Test
    fun shouldDisplayForecastList() {
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        val forecastList = activity.findViewById(R.id.forecast_list) as RecyclerView

        assertThat((forecastList.adapter as ForecastListAdapter).items)
                .hasSameElementsAs(activity.items)
    }

}