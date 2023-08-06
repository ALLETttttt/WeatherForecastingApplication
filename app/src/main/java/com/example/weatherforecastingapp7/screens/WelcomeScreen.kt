package com.example.weatherforecastingapp7.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherforecastingapp7.R
import com.example.weatherforecastingapp7.ui.theme.BlueLight


@Composable
fun WelcomeScreen(navController: NavController) {
    Image(
        painter = painterResource(id = R.drawable.weather_bg),
        modifier = Modifier.fillMaxSize(),
        contentDescription = "welcome",
        contentScale = ContentScale.FillBounds
    )
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
        ) {
            Text(
                text = "Weather Forecasting Application",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 8.dp, top = 15.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                backgroundColor = BlueLight,
                elevation = 0.dp,
                shape = RoundedCornerShape(13.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 11.dp,
                            bottom = 11.dp,
                            start = 11.dp,
                            end = 11.dp
                        )
                ) {
                    Text(
                        text = "Explore accurate and real-time weather forecasts from around the globe. " +
                                "Become a part of our community and stay updated on all things weather-related. " +
                                "Receive timely alerts and predictions to keep you prepared for any weather event. " +
                                "Let our app be your guide, providing personalized forecasts tailored to your location.",
                        color = Color.White,
                        fontSize = 17.sp,
                    )

                }
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(53.dp),
                colors = ButtonDefaults.buttonColors(Color(46, 211, 52, 223)),
                onClick = {
                    navController.navigate("main_screen")
                }
            ) {
                Text(
                    text = "Getting Started ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
                Icon(
                    painter = painterResource(id = R.drawable.start),
                    contentDescription = "some start"
                )
            }
        }
    }

}