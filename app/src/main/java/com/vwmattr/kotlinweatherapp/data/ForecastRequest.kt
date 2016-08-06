package com.vwmattr.kotlinweatherapp.data

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 * Super simple HTTP request for forecast data.
 *
 * @param zipCode - The zipCode to request forecast data for.
 */
class ForecastRequest(val zipCode: String) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL =
                "http://api.openweathermap.org/data/2.5/" +
                        "forecast/daily?mode=json&units=imperial&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute() : ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}