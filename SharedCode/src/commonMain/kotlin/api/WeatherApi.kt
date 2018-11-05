package org.kotlin.mpp.mobile.api

import api.ExpectSuccess
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.http.HttpHeaders
import io.ktor.http.takeFrom
import org.kotlin.mpp.mobile.model.WeatherResponse

internal class WeatherApi(private val baseUrl: String) {

    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer().apply {
                setMapper(WeatherResponse::class, WeatherResponse.serializer())
            }
        }
        install(ExpectSuccess)
    }

    suspend fun getWeather(lat: Double, lon: Double): WeatherResponse {
        return client.get {
            apiUrl("data/2.5/weather")
            parameter("lat", lat)
            parameter("lon", lon)
            parameter("APPID", "f25cb1966fafde58e3c9b8ab73d8c4ac")
        }
    }

    private fun HttpRequestBuilder.apiUrl(path: String) {
        header(HttpHeaders.CacheControl, "no-cache")
        url {
            takeFrom(baseUrl)
            encodedPath = path
        }
    }
}