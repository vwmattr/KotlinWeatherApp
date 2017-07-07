package com.vwmattr.kotlinweatherapp.dagger.module

import com.vwmattr.kotlinweatherapp.dagger.ActivityScope
import com.vwmattr.kotlinweatherapp.ui.ForecastView
import com.vwmattr.kotlinweatherapp.ui.presenter.ForecastPresenter
import dagger.Module
import dagger.Provides

/**
 * Module providing dependencies for the [ForecastActivity].
 */
@Module
class ForecastActivityModule
    constructor(val forecastView: ForecastView) {

    @ActivityScope
    @Provides
    fun provideForecastPresenter() : ForecastPresenter {
        return ForecastPresenter(forecastView)
    }

}
