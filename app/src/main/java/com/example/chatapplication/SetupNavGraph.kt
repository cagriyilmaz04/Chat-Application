package com.example.chatapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(navController:NavHostController){

    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(route= Screen.Splash.route){
            SplashScreen(navController)
        }
        composable(route= Screen.LogIn.route){
            LogInScreen(navController)
        }
        composable(route= Screen.Register.route){
            RegisterScreen()
        }
    }
}