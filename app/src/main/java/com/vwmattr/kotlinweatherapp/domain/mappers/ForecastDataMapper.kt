package com.vwmattr.kotlinweatherapp.domain.mappers

import com.vwmattr.kotlinweatherapp.data.Forecast
import com.vwmattr.kotlinweatherapp.data.ForecastResult
import com.vwmattr.kotlinweatherapp.domain.model.ForecastList
import com.vwmattr.kotlinweatherapp.domain.model.Forecast as ModelForecast
import java.text.DateFormat
import java.util.*

/**
 * Mapper class for converting Data model classes to domain model classes.
 */

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name,
                forecast.city.country,
                convertForecastListToDomain(forecast.list))

    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt())

    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}