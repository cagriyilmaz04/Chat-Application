package com.example.chatapplication

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay

@Composable

fun SplashScreen(navController:NavController) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash))

    LottieAnimation(modifier = Modifier.fillMaxSize(),composition = composition, iterations = 1)

    LaunchedEffect(composition) {
        composition?.let {
            delay(3000L)
            navController.navigate(route = Screen.LogIn.route)
        }

    }
}