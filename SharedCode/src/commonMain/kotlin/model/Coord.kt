package org.kotlin.mpp.mobile.model

import kotlinx.serialization.Serializable

@Serializable
data class Coord (private val lat: Double,
                  private val lon: Double)