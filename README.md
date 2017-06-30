# kotlin-weather
Simple android weather app developed in kotlin, demonstrating the use of RxJava, Retrofit and implementing MVP.

# Screenshots
<img src="https://github.com/gurleensethi/kotlin-weather/blob/master/Screenshots/screenshot_1.png" width="350"/> <img src="https://github.com/gurleensethi/kotlin-weather/blob/master/Screenshots/screenshot_2.png" width="350"/> 

# Overview
Weather app created using the [Weather Api](https://market.mashape.com/fyhao/weather-13) from Mashape marketplace.
This is not supposed to be a production scale application, it is meant to demonstrate the implementation of **MVP** architecture in Kotlin using following libraries:
* RxJava
* Retrofit

##### Still if you have any issues or suggestions, please feel free to open an [issue](https://github.com/gurleensethi/kotlin-weather/issues/new)

### General flow of data
* Check if there is cached data present in the internal file, if yes then load the cached data.
* Retrieve the latitude and longitude of the user.
* Request data from Weather Api
* If data received, cache it in internal file and show the updated data to user.
* If error then notify user about it.

### Build the Project
To build the project on your own follow these steps:
* Clone the project
* Get an API key from [Weather Api](https://market.mashape.com/fyhao/weather-13)
* Create a Kotlin file named `Secrets.kt`
* In that file create an `object` and add a variable `API_KEY` that contains the key that you got from the Weather Api.
```kotlin
object Secrets {
    val API_KEY = "your_api_key"
}
```
* Build the project!
