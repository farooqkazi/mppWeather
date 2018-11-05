package org.kotlin.mpp.mobile.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rain (
    @SerialName("1h")
    val time: Double
)