package com.example.weatherforecastingapp7.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherforecastingapp7.R
import com.example.weatherforecastingapp7.ui.theme.BlueLight


@Preview(showBackground = true)
@Composable
fun WelcomeScreen() {
    Image(
        painter = painterResource(id = R.drawable.weather_bg),
        modifier = Modifier.fillMaxSize(),
        contentDescription = "splash",
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
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
                Text(text = "qwdqwdwejnver o vni erbvnuerbneu biperbebupvae rbvpiraebvae iprvbae [rvbaurvbawevewwewegwgwegww")
            }
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(),

        ) {
            Text(text = "Getting Started")
        }
    }
}