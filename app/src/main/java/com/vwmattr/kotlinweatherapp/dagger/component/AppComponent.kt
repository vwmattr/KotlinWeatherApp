package com.vwmattr.kotlinweatherapp.dagger.component

import com.vwmattr.kotlinweatherapp.dagger.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Top level component for KotlinWeatherApp dagger graph.
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class
))
interface AppComponent {

}