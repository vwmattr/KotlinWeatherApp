package com.vwmattr.kotlinweatherapp.data

import android.util.Log
import java.net.URL

/**
 * Super simple HTTP request for the provided url.
 *
 * @param url - The URL to fetch data from.
 */
class Request(val url: String) {

    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}