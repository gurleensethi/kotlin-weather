package app.com.thetechnocafe.kotlinweather.Home

import android.content.Context
import app.com.thetechnocafe.kotlinweather.Consts.Constants
import app.com.thetechnocafe.kotlinweather.Models.WeatherData
import app.com.thetechnocafe.kotlinweather.Networking.NetworkService
import app.com.thetechnocafe.kotlinweather.Consts.Secrets
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.File

/**
 * Created by gurleensethi on 21/06/17.
 */
class HomePresenter : HomeContract.Presenter {

    var mView: HomeContract.View? = null

    override fun subscribe(view: HomeContract.View) {
        mView = view

        //Load data from internal storage
        val storedWeather = getFileFromStorage(mView?.getContext())
        if (storedWeather != null) {
            mView?.onStoredDataFetched(storedWeather)
        }
    }

    override fun unSubscribe() {
        mView = null
    }

    override fun refresh(lat: Double, long: Double) {
        NetworkService.getMetaWeatherApi()
                .getLocationDetails(Secrets.API_KEY, Constants.TYPE_TEXT_PLAIN, lat, long)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    weatherData ->
                    mView?.onDataFetched(weatherData)
                    storeFileToExternalStorage(weatherData, mView?.getContext())
                }, {
                    error ->
                    mView?.onError()
                })
    }

    /*
    * Save the data in internal file as a json structure
    */
    private fun storeFileToExternalStorage(weatherData: WeatherData, context: Context?) {
        val gson = Gson()
        val weatherJson = gson.toJson(weatherData)

        val weatherFile = File(mView?.getContext()?.filesDir, Constants.WEATHER_FILE_NAME)
        if (weatherFile.exists()) weatherFile.delete()
        weatherFile.createNewFile()

        val outputStream = mView?.getContext()?.openFileOutput(Constants.WEATHER_FILE_NAME, Context.MODE_PRIVATE)
        outputStream?.write(weatherJson.toByteArray())
        outputStream?.close()
    }

    /*
    * Get the saved weather data from the file
    */
    private fun getFileFromStorage(context: Context?): WeatherData? {
        try {
            val weatherFile = File(context?.filesDir, Constants.WEATHER_FILE_NAME)
            val weatherJson = weatherFile.readText()
            val gson = Gson()
            val weatherData = gson.fromJson(weatherJson, WeatherData::class.java)
            return weatherData
        } catch (e: Exception) {
            return null
        }
    }
}