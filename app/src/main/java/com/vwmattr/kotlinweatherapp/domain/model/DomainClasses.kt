package com.vwmattr.kotlinweatherapp.domain.model

/**
 * Domain model classes for the WeatherAPp
 */
data class ForecastList(val city: String,
                        val country: String,
                        val dailyForecast:List<Forecast>)

data class Forecast(val date: String,
                    val description: String,
                    val high: Int,
                    val low: Int)