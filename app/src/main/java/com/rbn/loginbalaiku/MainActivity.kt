package com.rbn.loginbalaiku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rbn.loginbalaiku.ui.theme.LoginBalaikuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginBalaikuTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") { LoginForm(navController) }
                    composable("signup") { SignUpForm(navController) }
                    composable("forgot_password") { ForgotPasswordForm(navController) }
                    composable("home_page") { HomePage(navController) }
                    composable("jadwal") { Jadwal(navController) }
                    composable("Booking") { BookingForm(navController) }
                }
            }
        }
    }
}
