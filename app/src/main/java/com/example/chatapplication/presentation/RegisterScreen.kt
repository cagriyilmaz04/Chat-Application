package com.example.chatapplication.presentation

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chatapplication.auth.FirebaseAuthResult
import com.example.chatapplication.auth.createUser
import com.example.chatapplication.ui.theme.ChatApplicationTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(navController:NavController) {
    var mail by remember { mutableStateOf("") }
    var passwordAgain by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    val context = LocalContext.current

    Box(modifier = Modifier
        .size(700.dp)
        .padding(start = 16.dp, top = 48.dp, end = 16.dp), contentAlignment = Alignment.TopCenter) {
        Card( modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(8.dp)) {
            Column(modifier = Modifier
                .fillMaxSize(),verticalArrangement = Arrangement.spacedBy(4.dp)) {
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
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(12.dp)
                )

                OutlinedTextField(
                    value = userName,
                    onValueChange = { userName = it },
                    label = { Text(color = Color.Black, text = "Kullanıcı Adı") },
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(16.dp),
                    shape = RoundedCornerShape(12.dp)
                )

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
                    .padding(16.dp),onClick = {
                        if(checkRegisterControl(mail,password,passwordAgain,userName,context)){
                            GlobalScope.launch {
                                createUser(email = mail, password =  password).collect { result ->
                                    when (result) {
                                        is FirebaseAuthResult.Loading -> showLoading()
                                        is FirebaseAuthResult.Success -> {
                                            navController.popBackStack()
                                        }
                                        is FirebaseAuthResult.Failure -> {

                                        }
                                    }
                                }
                            }
                        }

                        }) {
                    Text(text = "Kayıt Ol")
                }

            }
        }

    }

}
fun showLoading() {
    Log.e("TAG","Burası")
}
fun checkRegisterControl(
    mail: String,
    password: String,
    passwordAgain: String,
    userName: String,
    context: Context
): Boolean {
        if(!(mail.isEmpty()||password.isEmpty()||passwordAgain.isEmpty()||userName.isEmpty())){
                if(password.length<6){
                    Toast.makeText(context,"Şifreniz 6 karakterden uzun olmalı",Toast.LENGTH_LONG).show()
                    return false
                }else{
                  if(password.equals(passwordAgain)){
                      return true
                  }
                    return false
                }
        }else{
            return false
        }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    ChatApplicationTheme {
        RegisterScreen(rememberNavController())
    }
}