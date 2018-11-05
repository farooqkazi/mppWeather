package org.kotlin.mpp.mobile.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val coord: Coord,
    val weather: List<Weather>,
    val base: String,
    val main: Temperature,
    val visibility: Int,
    val wind: Wind,
    val rain: Rain,
    val clouds: Clouds,
    val dt: Long,
    val sys: Sys,
    val id: Int,
    val name: String,
    val cod: Int
)