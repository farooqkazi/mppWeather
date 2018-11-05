package org.kotlin.mpp.mobile.presentation

import kotlinx.coroutines.launch
import org.kotlin.mpp.mobile.domain.UseCaseFactory
import org.kotlin.mpp.mobile.model.WeatherResponse

class WeatherViewModel(
    private val stateListener: (WeatherState) -> Nothing
) {
    private val scope = UICoroutineScope()
    private val useCaseFactory = UseCaseFactory()
    private val getRepositoryUseCase = useCaseFactory.createGetWeatherUseCase()
    private var state = WeatherState()

    init {
        stateListener.invoke(state)
    }

    fun loadWeather() {
        updateState(state.copy(isLoading = true))
        scope.launch {
            val weather = getRepositoryUseCase.execute()
            val weatherDescription = getWeatherDescription(weather)
            updateState(state.copy(weatherDescription = weatherDescription, isLoading = false))
        }.invokeOnCompletion {error ->
            error?.cause?.let {
                println("error $it")
                println("${it.message}")
                updateState(state.copy(isLoading = false))
            }
        }
    }

    private fun getWeatherDescription(weather: WeatherResponse): String {
        return "Weather in ${weather.name} is ${weather.main.temp_min}°F - ${weather.main.temp_max}°F"
    }

    private fun updateState(newState: WeatherState) {
        state = newState
        stateListener.invoke(state)
    }
}