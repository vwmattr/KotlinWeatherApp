package com.vwmattr.kotlinweatherapp

import android.support.v7.widget.RecyclerView
import com.vwmattr.kotlinweatherapp.ui.activities.MainActivity
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
        val forecastList = activity.findViewById(R.id.forecastList) as RecyclerView

        //TODO: Figure out how to test this (migrate to MVP pattern and inject stuff?)
//        assertThat((forecastList.adapter as ForecastListAdapter).items)
//                .hasSameElementsAs(activity.items)
    }

}