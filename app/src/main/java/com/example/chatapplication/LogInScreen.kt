package com.example.chatapplication

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chatapplication.ui.theme.ChatApplicationTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun LogInScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(color = Color.Black, text = "Kullanıcı Adı") },
                modifier = Modifier.fillMaxWidth(0.8f),
                shape = RoundedCornerShape(12.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(color = Color.Black, text = "Şifre") },
                modifier = Modifier.fillMaxWidth(0.8f),
                shape = RoundedCornerShape(12.dp)
            )
            val context = LocalContext.current
            Button(

                onClick = {
                          if(checkCondition(username,password,context)){

                          }

                },
                modifier = Modifier.fillMaxWidth(0.8f).height(50.dp)
            ) {
                Text("Giriş Yap")
            }
            Text("Kaydınız yok mu? Şimdi kaydolun!", modifier = Modifier.clickable { navController.navigate(Screen.Register.route) })
        }
    }
}

fun checkCondition(username: String, password: String,context:Context): Boolean {
    if(username.isEmpty()||password.isEmpty()){
        Toast.makeText(context,"Boş yerleri doldurunuz",Toast.LENGTH_LONG).show()
        return false
    }
    return true
}


@Preview(showBackground = true)
@Composable
fun PreviewLogInScreen() {
    ChatApplicationTheme {
        val navController = rememberNavController()
        LogInScreen(navController = navController)
    }
}
