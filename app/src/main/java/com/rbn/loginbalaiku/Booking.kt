package com.rbn.loginbalaiku

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun BookingForm(navController: NavController) {
    var checkInDate by remember { mutableStateOf("07.08.2017") }
    var checkOutDate by remember { mutableStateOf("07.08.2017") }
    val openCheckInDialog = remember { mutableStateOf(false) }
    val openCheckOutDialog = remember { mutableStateOf(false) }
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var agenda by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1F5F8)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .width(300.dp)
                .background(Color.White, shape = RoundedCornerShape(10.dp))
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Book Balai Desa",
                fontSize = 24.sp,
                color = Color(0xFF164863),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = checkInDate,
                    onValueChange = { checkInDate = it },
                    label = { Text("Check In") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f).clickable { openCheckInDialog.value = true }
                )

                Spacer(modifier = Modifier.width(8.dp))

                OutlinedTextField(
                    value = checkOutDate,
                    onValueChange = { checkOutDate = it },
                    label = { Text("Check Out") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f).clickable { openCheckOutDialog.value = true }
                )


                Spacer(modifier = Modifier.width(8.dp))

            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = agenda,
                onValueChange = { agenda = it },
                label = { Text("Agenda") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Handle search action */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF164863))
            ) {
                Text(text = "CONFIRM", color = Color.White)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(Color.LightGray)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp)
                    .clickable { navController.navigate("home_page") }
            )
            Spacer(modifier = Modifier.width(40.dp))
            Image(
                painter = painterResource(id = R.drawable.booking),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp)
                    .clickable { navController.navigate("Booking") }
            )
            Spacer(modifier = Modifier.width(40.dp))
            Image(
                painter = painterResource(id = R.drawable.schedule),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp)
                    .clickable { navController.navigate("jadwal") }
            )
        }
    }
}