package com.rbn.loginbalaiku

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
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
import com.google.firebase.database.FirebaseDatabase

@Composable
fun SignUpForm(navController: NavController, modifier: Modifier = Modifier) {
    val name = remember { mutableStateOf("") }
    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val auth = FirebaseAuth.getInstance()
    val database = FirebaseDatabase.getInstance().reference
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        // Background
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
            Text("Create an Account", fontSize = 24.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = username.value,
                onValueChange = { username.value = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(autoCorrect = false)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    Log.d("SignUpForm", "Sign up button clicked")
                    auth.createUserWithEmailAndPassword(email.value, password.value)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d("SignUpForm", "User created successfully")
                                val userId = auth.currentUser?.uid ?: ""
                                val user = User(name.value, username.value, email.value)
                                database.child("users").child(userId).setValue(user)
                                    .addOnCompleteListener { dbTask ->
                                        if (dbTask.isSuccessful) {
                                            Log.d("SignUpForm", "User data saved to database")
                                            navController.navigate("login") {
                                                popUpTo(navController.graph.startDestinationId) {
                                                    inclusive = true
                                                }
                                            }
                                            Toast.makeText(context, "Sign up successful!", Toast.LENGTH_SHORT).show()
                                        } else {
                                            val dbErrorMessage = dbTask.exception?.message
                                            Log.e("SignUpForm", "Failed to save user data: $dbErrorMessage")
                                            Toast.makeText(context, "Failed to save user data: $dbErrorMessage", Toast.LENGTH_LONG).show()
                                        }
                                    }
                            } else {
                                val errorMessage = task.exception?.message
                                Log.e("SignUpForm", "Sign up failed: $errorMessage")
                                Toast.makeText(context, "Sign up failed: $errorMessage", Toast.LENGTH_LONG).show()
                            }
                        }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("SIGN UP", color = Color.White)
            }
        }
    }
}

data class User(val name: String, val username: String, val email: String)
