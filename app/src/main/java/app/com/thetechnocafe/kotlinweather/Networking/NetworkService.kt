package app.com.thetechnocafe.kotlinweather.Networking

import app.com.thetechnocafe.kotlinweather.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
        val client = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(interceptor)

        retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getMetaWeatherApi() = retrofit.create(MetaWeatherApi::class.java)
}