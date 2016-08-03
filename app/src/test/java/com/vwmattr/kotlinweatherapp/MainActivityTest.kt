package com.vwmattr.kotlinweatherapp

import android.widget.TextView
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
    fun itShouldDisplayHelloKotlin() {
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        val textView = activity.findViewById(R.id.message) as TextView

        assertThat(textView.text).isEqualTo("Hello Kotlin!")
    }

}