package app.com.thetechnocafe.kotlinweather.Home

import android.content.Context
import app.com.thetechnocafe.kotlinweather.Models.WeatherData

/**
 * Created by gurleensethi on 21/06/17.
 */
interface HomeContract {
    interface View {
        fun onDataFetched(weatherData: WeatherData?)

        fun onStoredDataFetched(weatherData: WeatherData?)

        fun onError()

        fun getContext(): Context
    }

    interface Presenter {
        fun subscribe(view: HomeContract.View)

        fun unSubscribe()

        fun refresh(lat: Double, long: Double);
    }
}