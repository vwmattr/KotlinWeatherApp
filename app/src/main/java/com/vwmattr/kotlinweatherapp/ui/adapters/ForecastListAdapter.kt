package com.vwmattr.kotlinweatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.vwmattr.kotlinweatherapp.R
import com.vwmattr.kotlinweatherapp.domain.model.Forecast
import com.vwmattr.kotlinweatherapp.domain.model.ForecastList
import com.vwmattr.kotlinweatherapp.ui.utils.ctx
import org.jetbrains.anko.find

/**
 * ForecastListAdapter for displaying forecasts in MainActivity.
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

        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high.toString()}"
                minTemperatureView.text = "${low.toString()}"
                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }

}
