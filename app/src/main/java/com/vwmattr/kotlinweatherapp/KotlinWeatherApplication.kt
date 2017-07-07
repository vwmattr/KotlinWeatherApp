package com.vwmattr.kotlinweatherapp

import android.app.Application
import com.vwmattr.kotlinweatherapp.dagger.component.AppComponent
import com.vwmattr.kotlinweatherapp.dagger.component.DaggerAppComponent
import com.vwmattr.kotlinweatherapp.dagger.module.AppModule

/**
 * The Android Application singleton for KotlinWeatherApp.
 */
class KotlinWeatherApplication : Application() {

    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

}