package app.com.thetechnocafe.kotlinweather.Models

import java.io.Serializable

/**
 * Created by gurleensethi on 16/06/17.
 */

data class WeatherData(
        val query: Query
) : Serializable

data class Query(
        val count: Int,
        val created: String,
        val lang: String,
        val results: Results
) : Serializable

data class Results(
        val channel: Channel
) : Serializable

data class Channel(
        val title: String,
        val link: String,
        val description: String,
        val language: String,
        val lastBuildDate: String,
        val ttl: String,
        val location: Location,
        val units: Units,
        val wind: Wind,
        val atmosphere: Atmosphere,
        val astronomy: Astronomy,
        val image: Image,
        val item: Item
) : Serializable

data class Location(
        val city: String,
        val country: String,
        val region: String
) : Serializable

data class Units(
        val distance: String,
        val pressure: String,
        val speed: String,
        val temperature: String
) : Serializable

data class Wind(
        val chill: String,
        val direction: String,
        val speed: String
) : Serializable

data class Atmosphere(
        val humidity: String,
        val pressure: String,
        val rising: String,
        val visibility: String
) : Serializable

data class Astronomy(
        val sunrise: String,
        val sunset: String
) : Serializable

data class Image(
        val title: String,
        val width: String,
        val height: String,
        val link: String,
        val url: String
) : Serializable

data class Item(
        val title: String,
        val lat: String,
        val long: String,
        val link: String,
        val pubDate: String,
        val condition: Condition,
        val description: String,
        val forecast: Array<Forecast>,
        val guid: Guid
) : Serializable

data class Condition(
        val code: String,
        val date: String,
        val temp: String,
        val text: String
) : Serializable

data class Forecast(
        val code: String,
        val date: String,
        val day: String,
        val high: String,
        val low: String,
        val text: String
) : Serializable

data class Guid(
        val isPermaLink: String,
        val content: String
) : Serializable