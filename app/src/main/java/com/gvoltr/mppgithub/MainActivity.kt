package com.gvoltr.mppgithub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.kotlin.mpp.mobile.presentation.WeatherViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val reposViewModel = WeatherViewModel {
            textView.text = it.weatherDescription
            progressBar.visibility = if (it.isLoading) View.VISIBLE else View.INVISIBLE
        }

        loadWeatherBtn.setOnClickListener { reposViewModel.loadWeather() }
    }
}
