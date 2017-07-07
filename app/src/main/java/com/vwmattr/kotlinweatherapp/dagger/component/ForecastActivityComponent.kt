package com.vwmattr.kotlinweatherapp.dagger.component

import com.vwmattr.kotlinweatherapp.dagger.ActivityScope
import com.vwmattr.kotlinweatherapp.dagger.module.ForecastActivityModule
import com.vwmattr.kotlinweatherapp.ui.activities.ForecastActivity
import dagger.Component

/**
 * Dagger component that injects [ForecastActivity]
 */
@ActivityScope
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(ForecastActivityModule::class)
)
interface ForecastActivityComponent {
    fun inject(activity: ForecastActivity)
}