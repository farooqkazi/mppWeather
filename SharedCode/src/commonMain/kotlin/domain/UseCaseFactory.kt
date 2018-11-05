package org.kotlin.mpp.mobile.domain

import org.kotlin.mpp.mobile.api.WeatherApi

internal class UseCaseFactory {

    val weatherApi = WeatherApi("https://api.openweathermap.org/")

    fun createGetWeatherUseCase() = GetWeatherUseCase(weatherApi)

}