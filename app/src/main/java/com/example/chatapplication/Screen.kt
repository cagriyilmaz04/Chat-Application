package com.example.chatapplication

sealed class Screen(val route: String){
    object Splash:Screen(route = "splash_screen")
    object LogIn:Screen(route="login_screen")
    object Register:Screen(route="register_screen")


}


