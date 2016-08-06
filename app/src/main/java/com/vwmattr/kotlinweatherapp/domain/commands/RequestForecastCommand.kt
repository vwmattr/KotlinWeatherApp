package com.vwmattr.kotlinweatherapp.domain.commands

import com.vwmattr.kotlinweatherapp.data.ForecastRequest
import com.vwmattr.kotlinweatherapp.domain.mappers.ForecastDataMapper
import com.vwmattr.kotlinweatherapp.domain.model.ForecastList

/**
 * Command for requesting forecast data for a given zipCode.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}
