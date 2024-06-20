package com.rbn.loginbalaiku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Jadwal(navController: NavController, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.logo_balaiku),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .align(Alignment.CenterHorizontally)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(15) { index ->
                val checkInDate = when (index) {
                    0 -> "23 - 06 - 2024"
                    1 -> "25 - 06 - 2024"
                    2 -> "27 - 06 - 2024"
                    3 -> "29 - 06 - 2024"
                    4 -> "01 - 07 - 2024"
                    5 -> "03 - 07 - 2024"
                    6 -> "05 - 07 - 2024"
                    7 -> "07 - 07 - 2024"
                    8 -> "09 - 07 - 2024"
                    9 -> "11 - 07 - 2024"
                    10 -> "13 - 07 - 2024"
                    11 -> "15 - 07 - 2024"
                    12 -> "17 - 07 - 2024"
                    13 -> "19 - 07 - 2024"
                    14 -> "21 - 07 - 2024"
                    else -> ""
                }
                val checkOutDate = when (index) {
                    0 -> "24 - 06 - 2024"
                    1 -> "26 - 06 - 2024"
                    2 -> "28 - 06 - 2024"
                    3 -> "30 - 06 - 2024"
                    4 -> "02 - 07 - 2024"
                    5 -> "04 - 07 - 2024"
                    6 -> "06 - 07 - 2024"
                    7 -> "08 - 07 - 2024"
                    8 -> "10 - 07 - 2024"
                    9 -> "12 - 07 - 2024"
                    10 -> "14 - 07 - 2024"
                    11 -> "16 - 07 - 2024"
                    12 -> "18 - 07 - 2024"
                    13 -> "20 - 07 - 2024"
                    14 -> "22 - 07 - 2024"
                    else -> ""
                }
                val agenda = when (index) {
                    0 -> "Khitanan Reza Gunawan"
                    1 -> "Pernikahan Anisa & Budi"
                    2 -> "Workshop Fotografi"
                    3 -> "Seminar Kesehatan"
                    4 -> "Ulang Tahun Perusahaan"
                    5 -> "Rapat Bulanan"
                    6 -> "Lomba Cerdas Cermat"
                    7 -> "Bazar Buku"
                    8 -> "Pelatihan Kewirausahaan"
                    9 -> "Donor Darah"
                    10 -> "Pentas Seni"
                    11 -> "Diskusi Literasi"
                    12 -> "Lomba Mewarnai"
                    13 -> "Festival Musik"
                    14 -> "Karnaval Budaya"
                    else -> ""
                }

                Column {
                    ScheduleItem(checkInDate, checkOutDate, agenda)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(Color.LightGray)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clickable { navController.navigate("home_page") }
            )
            Spacer(modifier = Modifier.width(40.dp))
            Image(
                painter = painterResource(id = R.drawable.booking),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clickable { navController.navigate("Booking") }
            )
            Spacer(modifier = Modifier.width(40.dp))
            Image(
                painter = painterResource(id = R.drawable.schedule),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clickable { navController.navigate("jadwal") }
            )
            Spacer(modifier = Modifier.width(40.dp))
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clickable { navController.navigate("profile") }
            )
        }
    }
}

@Composable
fun ScheduleItem(checkInDate: String, checkOutDate: String, agenda: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(10.dp)) // Added border
            .background(Color.White)
            .padding(10.dp)
    ) {
        Text(text = "Check-in: $checkInDate")
        Text(text = "Check-out: $checkOutDate")
        Text(text = "Agenda: $agenda")
    }
}
