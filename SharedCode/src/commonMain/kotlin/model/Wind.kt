package org.kotlin.mpp.mobile.model

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Serializable
data class Wind (val speed: Double,
                 val deg: Double,
                 @Optional
                 val gust: Double = 0.0)