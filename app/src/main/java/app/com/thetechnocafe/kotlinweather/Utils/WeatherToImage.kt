package app.com.thetechnocafe.kotlinweather.Utils

import app.com.thetechnocafe.kotlinweather.R

/**
 * Created by gurleensethi on 23/06/17.
 */
object WeatherToImage {
    fun getImageForCode(code: String): Int = when (code) {
        "1" -> {
            R.drawable.clouds_with_lighting_littlerain_01
        }
        "3", "37", "38", "39" -> {
            R.drawable.clouds_with_2lighting_01
        }
        "4" -> {
            R.drawable.clouds_with_lighting_01
        }
        "5", "6", "7", "13", "14", "15", "16", "18", "41", "42", "43", "46" -> {
            R.drawable.clouds_with_snow_01
        }
        "10", "11", "12", "17", "35", "40", "47" -> {
            R.drawable.clouds_with_rain_01
        }
        "26", "27", "29", "44" -> {
            R.drawable.clouds_01
        }
        "28" -> {
            R.drawable.sun_with_3clouds_01
        }
        "30" -> {
            R.drawable.sun_with_1cloud_01
        }
        "31", "33" -> {
            R.drawable.moon_01
        }
        "32", "34", "36" -> {
            R.drawable.sun_01
        }
        "45" -> {
            R.drawable.clouds_with_lighting_rain_01
        }
        else -> {
            R.drawable.ic_icon
        }
    }
}