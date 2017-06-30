# kotlin-weather
Simple android weather app developed in kotlin, demonstrating the use of RxJava, Retrofit and implementing MVP.

# Screenshots
<img src="https://github.com/gurleensethi/kotlin-weather/blob/master/Screenshots/screenshot_1.png" width="350"/> <img src="https://github.com/gurleensethi/kotlin-weather/blob/master/Screenshots/screenshot_2.png" width="350"/> 

# Overview
Weather app created using the [Weather Api](https://market.mashape.com/fyhao/weather-13) from Mashape marketplace.
This is not supposed to be a production scale application, it is meant to demonstrate the implementation of **MVP** architecture in Kotlin using following libraries:
* RxJava
* Retrofit

### General flow of data
* Check if there is cached data present in the internal file, if yes then load the cached data.
* Retrieve the latitude and longitude of the user.
* Request data from Weather Api
* If data received, cache it in internal file and show the updated data to user.
* If error then notify user about it.
