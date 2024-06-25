package com.rbn.loginbalaiku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rbn.loginbalaiku.ui.theme.LoginBalaikuTheme
import android.app.Application
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            LoginBalaikuTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") { LoginForm(navController) }
                    composable("signup") { SignUpForm(navController) }
                    composable("forgot_password") { ForgotPasswordForm(navController) }
                    composable("home_page") { HomePage(navController) }
                    composable("jadwal") { Jadwal(navController) }
                    composable("profile") { Profile(navController) }
                    composable("Booking") { BookingForm(navController) }
                }
            }
        }
    }
}
