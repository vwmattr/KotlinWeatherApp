package com.vwmattr.kotlinweatherapp.ui.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.vwmattr.kotlinweatherapp.R
import com.vwmattr.kotlinweatherapp.dagger.component.DaggerForecastActivityComponent
import com.vwmattr.kotlinweatherapp.dagger.module.ForecastActivityModule
import com.vwmattr.kotlinweatherapp.domain.commands.RequestForecastCommand
import com.vwmattr.kotlinweatherapp.domain.model.ForecastList
import com.vwmattr.kotlinweatherapp.ui.ForecastView
import com.vwmattr.kotlinweatherapp.ui.adapters.ForecastListAdapter
import com.vwmattr.kotlinweatherapp.ui.presenter.ForecastPresenter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class ForecastActivity : ForecastView, BaseActivity() {

    @Inject
    lateinit var presenter : ForecastPresenter

    lateinit var forecastList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        forecastList = findViewById(R.id.forecastList) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this)

        //TODO: Move this to the ForecastPresenter
        //TODO: make this Rx-ified in the presenter!
        doAsync() {
            val result = RequestForecastCommand("80237").execute()
            uiThread {
                displayForecast(result)
            }
        }

    }

    override fun onStart() {
        super.onStart()
        presenter.startPresenting()
    }

    override fun onStop() {
        super.onStop()
        presenter.stopPresenting()
    }

    override fun displayForecast(forecast: ForecastList) {
        val adapter = ForecastListAdapter(forecast) { toast(it.date + " :-)") }
        forecastList.adapter = adapter
    }

    override fun injectActivity() {
        DaggerForecastActivityComponent.builder()
                .appComponent(getAppComponent())
                .forecastActivityModule(ForecastActivityModule(this))
                .build()
                .inject(this)
    }

}
