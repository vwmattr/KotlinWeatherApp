package com.vwmattr.kotlinweatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.vwmattr.kotlinweatherapp.R
import com.vwmattr.kotlinweatherapp.domain.model.Forecast
import com.vwmattr.kotlinweatherapp.domain.model.ForecastList
import com.vwmattr.kotlinweatherapp.ui.utils.ctx
import kotlinx.android.synthetic.main.view_forecast_item.view.*

/**
 * ForecastListAdapter for displaying forecasts in ForecastActivity.
 * Added in Chapter 5.
 */
class ForecastListAdapter(val weekForecast: ForecastList,
            val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
                LayoutInflater.from(parent.ctx).inflate(R.layout.view_forecast_item, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]) {
            holder.bindForecast(weekForecast[position])
        }
    }

    override fun getItemCount() = weekForecast.size()

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) :
            RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "${high.toString()}"
                itemView.minTemperature.text = "${low.toString()}"
                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }

}
