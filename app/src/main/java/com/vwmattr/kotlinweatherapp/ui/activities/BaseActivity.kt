package com.vwmattr.kotlinweatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.vwmattr.kotlinweatherapp.KotlinWeatherApplication
import com.vwmattr.kotlinweatherapp.dagger.component.AppComponent

/**
 * Base Activity class for all Activities to extend. Handles common logic for Dagger injection, etc.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectActivity()
    }

    /**
     * Convenience method for getting the AppComponent instance.
     */
    fun getAppComponent() : AppComponent {
        val theApp : KotlinWeatherApplication = application as KotlinWeatherApplication
        return theApp.appComponent
    }

    /**
     * Implement in subclasses to do the actual injection.
     */
    abstract fun injectActivity()
}