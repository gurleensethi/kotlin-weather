package app.com.thetechnocafe.kotlinweather.Networking

import app.com.thetechnocafe.kotlinweather.Models.WeatherData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Created by gurleensethi on 16/06/17.
 */
interface MetaWeatherApi {
    @GET("weatherdata")
    fun getLocationDetails(@Header("X-Mashape-Key") key: String, @Header("Accept") type: String,
                           @Query("lat") lat: Double, @Query("lng") lng: Double): Observable<WeatherData>
}