package com.vwmattr.kotlinweatherapp.ui.presenter

import android.support.annotation.VisibleForTesting
import android.util.Log
import com.vwmattr.kotlinweatherapp.domain.commands.RequestForecastCommand
import com.vwmattr.kotlinweatherapp.ui.ForecastView
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Presenter for the ForecastView.
 */
class ForecastPresenter
constructor(val forecastView: ForecastView) {

    @VisibleForTesting
    var forecastDisposable: Disposable? = null

    fun startPresenting() {
        //TODO: Figure out a way to refactor this to make it more testable...
        forecastDisposable = Single.just(RequestForecastCommand("80237"))
                .map(RequestForecastCommand::execute)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(forecastView::displayForecast,
                        { error ->
                            Log.e("ForecastPresenter", "Unable to load Forecast list", error)
                        })
    }

    fun stopPresenting() {
        forecastDisposable?.dispose()
        forecastDisposable = null
    }

}
