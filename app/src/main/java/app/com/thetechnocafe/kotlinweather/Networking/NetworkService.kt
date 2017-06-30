package app.com.thetechnocafe.kotlinweather.Networking

import app.com.thetechnocafe.kotlinweather.Consts.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


/**
 * Created by gurleensethi on 16/06/17.
 */
object NetworkService {
    val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getMetaWeatherApi() = retrofit.create(MetaWeatherApi::class.java)
}