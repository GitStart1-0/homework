package com.example.homework

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.math.BigDecimal
import java.math.RoundingMode

class Homework_17 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework_17)

        val textViewCity: TextView = findViewById(R.id.textViewCity)
        val textViewTemperature: TextView = findViewById(R.id.textViewTemperature)
        val textViewWind: TextView = findViewById(R.id.textViewWind)

        ApiClient.retrofit.create(ApiInterface::class.java)
            .getWeather("Odessa")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { response -> mapToDisplayItem(response) }
            .subscribe({
                textViewCity.text = "Odessa"
                textViewTemperature.text = "Temperature: ${it.temperature}"
                textViewWind.text = "Wind Speed: ${it.wind}"
            }, {
                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
            })
    }

    private fun mapToDisplayItem(response: WeatherResponse): DisplayWeatherItem {
        val temperature = response.temperature
        val wind = response.wind
        return DisplayWeatherItem(temperature, wind)
    }
}

data class DisplayWeatherItem(
    val temperature: String,
    val wind: String
)

data class WeatherResponse(
    val temperature: String,
    val wind: String,
    val description: String
)