package com.example.chatapplication.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chatapplication.ui.theme.ChatApplicationTheme

@Composable
fun RegisterScreen(navController:NavController) {
    var mail by remember { mutableStateOf("") }
    var passwordAgain by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(start = 16.dp, top = 48.dp, end = 16.dp), contentAlignment = Alignment.TopCenter) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
                value = mail,
                onValueChange = { mail = it },
                label = { Text(color = Color.Black, text = "E-mail") },
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(16.dp),
                shape = RoundedCornerShape(12.dp)
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(16.dp),
                value = password,
                onValueChange = { password = it },
                label = { Text(color = Color.Black, text = "Şifre") },
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(12.dp)
            )

            OutlinedTextField(
                value = passwordAgain,
                onValueChange = { passwordAgain = it },
                label = { Text(color = Color.Black, text = "Şifre Tekrar") },
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(16.dp),
                shape = RoundedCornerShape(12.dp)
            )

            Button(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .padding(16.dp),onClick = { navController.popBackStack()}) {
                Text(text = "Kayıt Ol")

            }


        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    ChatApplicationTheme {
        RegisterScreen(rememberNavController())
    }
}