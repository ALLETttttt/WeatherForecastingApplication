package com.example.weatherforecastingapp7

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherforecastingapp7.data.WeatherModel
import com.example.weatherforecastingapp7.screens.MainCard
import com.example.weatherforecastingapp7.screens.SplashScreen
import com.example.weatherforecastingapp7.screens.TabLayout
import com.example.weatherforecastingapp7.ui.theme.WeatherForecastingApp7Theme
import org.json.JSONObject


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherForecastingApp7Theme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "splash_screen") {

                    composable("splash_screen") {
                        SplashScreen(navController = navController)
                    }

                    composable("main_screen") {
                        start(this@MainActivity)
                    }
                }
            }
        }
    }
}

@Composable
private fun start(context: Context) {
    val daysList = remember {
        mutableStateOf(listOf<WeatherModel>())
    }
    val currentDay = remember {
        mutableStateOf(
            WeatherModel(
                "",
                "",
                "0.0",
                "",
                "",
                "0.0",
                "0.0",
                "",
            )
        )
    }
    getData("London", context, daysList, currentDay)
    Image(
        painter = painterResource(id = R.drawable.weather_bg),
        contentDescription = "bg",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Column {
        MainCard(currentDay, onClickSync = {
            getData("London", context, daysList, currentDay)
        })
        TabLayout(daysList, currentDay)
    }
}


const val API_KEY = "426b90f6a1dd4d17841142958230108"

private fun getData(
    city: String, context: Context,
    daysList: MutableState<List<WeatherModel>>, currentDay: MutableState<WeatherModel>
) {
    val url = "https://api.weatherapi.com/v1/forecast.json?key=" +
            "$API_KEY" +
            "&q=" +
            "$city" +
            "&days=" +
            "10" +
            "&aqi=no&alerts=no"

    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            val list = getWeatherByDays(response)
            currentDay.value = list[0]
            daysList.value = list
        },
        { error ->
        }
    )
    queue.add(sRequest)
}


private fun getWeatherByDays(response: String): List<WeatherModel> {

    if (response.isEmpty()) return listOf()
    val list = ArrayList<WeatherModel>()
    val mainObject = JSONObject(response)
    val city = mainObject.getJSONObject("location").getString("name")
    val days = mainObject.getJSONObject("forecast").getJSONArray("forecastday")

    for (i in 0 until days.length()) {
        val item = days[i] as JSONObject
        list.add(
            WeatherModel(
                city,
                item.getString("date"),
                "",
                item.getJSONObject("day").getJSONObject("condition")
                    .getString("text"),
                item.getJSONObject("day").getJSONObject("condition")
                    .getString("icon"),
                item.getJSONObject("day").getString("maxtemp_c"),
                item.getJSONObject("day").getString("mintemp_c"),
                item.getJSONArray("hour").toString()
            )
        )
    }
    list[0] = list[0].copy(
        time = mainObject.getJSONObject("current").getString("last_updated"),
        currentTemp = mainObject.getJSONObject("current").getString("temp_c")
    )
    return list
}

