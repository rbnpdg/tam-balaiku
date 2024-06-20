package com.rbn.loginbalaiku

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginForm(navController: NavController, modifier: Modifier = Modifier) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        //Background
        Image(
            painter = painterResource(id = R.drawable.bglogin),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            alignment = Alignment.Center
        )

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //Logo BalaiKu
            Image(painter = painterResource(id = R.drawable.logo_balaiku), contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 2.dp), alignment = Alignment.Center)

            Spacer(modifier = Modifier.height(16.dp))
            //Tagline
            Text("Nikmati kemudahan menggunakan Balai Desa", fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(16.dp))
            //Field username
            TextField(
                value = username.value,
                onValueChange = { username.value = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            //Field password
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(autoCorrect = false)
            )
            Spacer(modifier = Modifier.height(8.dp))
            //Forgot password
            TextButton(onClick = { navController.navigate("forgot_password") }) {
                Text("Forgot Password?", color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(16.dp))
            //Button sign in
            Button(
                onClick = { navController.navigate("home_page") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("SIGN IN", color = Color.White)
            }
            Spacer(modifier = Modifier.height(8.dp))
            //Sign up
            TextButton(onClick = { navController.navigate("signup") }) {
                Text("Don't have an account yet? Sign Up")
            }
        }
    }
}
