package org.kotlin.mpp.mobile.domain

import org.kotlin.mpp.mobile.api.WeatherApi
import org.kotlin.mpp.mobile.model.WeatherResponse

internal class GetWeatherUseCase (private val weatherApi: WeatherApi){

    suspend fun execute() : WeatherResponse {
        return weatherApi.getWeather(38.87, -77.10)
    }

}