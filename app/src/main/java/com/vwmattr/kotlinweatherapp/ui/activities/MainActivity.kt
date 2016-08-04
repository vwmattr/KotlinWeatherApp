package com.vwmattr.kotlinweatherapp.ui.activities

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.vwmattr.kotlinweatherapp.ui.adapters.ForecastListAdapter
import com.vwmattr.kotlinweatherapp.R
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {

    @VisibleForTesting
    val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thu 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList : RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)
    }
}