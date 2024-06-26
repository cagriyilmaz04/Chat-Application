package com.example.chatapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.chatapplication.navigation.SetupNavGraph
import com.example.chatapplication.ui.theme.ChatApplicationTheme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatApplicationTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)



            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChatApplicationTheme {
        SetupNavGraph(navController = rememberNavController())
    }
}