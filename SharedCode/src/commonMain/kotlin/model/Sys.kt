package org.kotlin.mpp.mobile.model

import kotlinx.serialization.Serializable

@Serializable
data class Sys(
    val id: Int,
    val type: Int,
    val message: Double,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)