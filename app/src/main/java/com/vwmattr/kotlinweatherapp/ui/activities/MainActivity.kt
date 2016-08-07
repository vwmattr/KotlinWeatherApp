package com.vwmattr.kotlinweatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.vwmattr.kotlinweatherapp.R
import com.vwmattr.kotlinweatherapp.domain.commands.RequestForecastCommand
import com.vwmattr.kotlinweatherapp.domain.model.Forecast
import com.vwmattr.kotlinweatherapp.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList : RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync() {
            val result = RequestForecastCommand("19426").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result,
                        object :
                ForecastListAdapter.OnItemClickListener {
                            override fun invoke(forecast: Forecast) {
                                toast(forecast.date)
                            }
                        })
            }
        }

    }
}
