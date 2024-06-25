package com.rbn.loginbalaiku

import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginForm(navController: NavController, modifier: Modifier = Modifier) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val context = LocalContext.current
    val auth = FirebaseAuth.getInstance()

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
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Email") },
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
                onClick = {
                    Log.d("LoginForm", "Login button clicked")
                    auth.signInWithEmailAndPassword(email.value, password.value)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d("LoginForm", "Login successful")
                                navController.navigate("home_page")
                                Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                            } else {
                                val errorMessage = task.exception?.message
                                Log.e("LoginForm", "Login failed: $errorMessage")
                                Toast.makeText(context, "Login failed: $errorMessage", Toast.LENGTH_LONG).show()
                            }
                        }
                },
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
