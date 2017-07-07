package com.vwmattr.kotlinweatherapp.ui

import com.vwmattr.kotlinweatherapp.domain.model.ForecastList

/**
 * Interface for Android View implementation that displays the Forecast to implement.
 */
interface ForecastView {
    fun displayForecast(forecastList : ForecastList)
}