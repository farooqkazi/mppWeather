package org.kotlin.mpp.mobile.model

import kotlinx.serialization.Serializable

@Serializable
data class Temperature(
    val temp: Double,
    val humidity: Int,
    val pressure: Int,
    val temp_min: Double,
    val temp_max: Double
)