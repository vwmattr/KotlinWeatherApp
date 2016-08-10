package com.vwmattr.kotlinweatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.vwmattr.kotlinweatherapp.R
import com.vwmattr.kotlinweatherapp.domain.commands.RequestForecastCommand
import com.vwmattr.kotlinweatherapp.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync() {
            val result = RequestForecastCommand("19426").execute()
            uiThread {
                val adapter = ForecastListAdapter(result) { toast(it.date) }
                forecastList.adapter = adapter
            }
        }

    }
}
