package com.example.weatherforecastingapp7.screens


import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.weatherforecastingapp7.R
import kotlinx.coroutines.delay



@Composable
fun SplashScreen(navController: NavController ) {
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate("welcome_screen")
    }

    Image(
        painter = painterResource(id = R.drawable.splash),
        modifier = Modifier.fillMaxSize(),
        contentDescription = "splash",
        contentScale = ContentScale.FillBounds
    )
}