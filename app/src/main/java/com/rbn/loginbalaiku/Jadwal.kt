package com.rbn.loginbalaiku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.math.absoluteValue


@Composable
fun Jadwal(navController: NavController, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Column{
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            ){
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 10.dp)
                ) {
                    Text(
                        text = "Jadwal",
                        color = Color.Black,
                        fontSize = 20. sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .height(30.dp) // Sesuaikan dengan jarak yang diinginkan
                    .fillMaxWidth()
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomStart = 20.dp,
                            bottomEnd = 20.dp
                        )
                    )
                    .background(Color.LightGray),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .height(80.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .clickable { /* Handle click */ }
                            .background(Color.White)
                            .padding(10.dp)
                            .fillMaxWidth()
                    ){
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter)) {
                            Text(text = "Jadwal: Senin, 23 - 06 - 2024")
                            Text(text = "Agenda: Pernikahan Rani dan Tono")
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier
                    .height(20.dp) // Sesuaikan dengan jarak yang diinginkan
                    .fillMaxWidth()
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomStart = 20.dp,
                            bottomEnd = 20.dp
                        )
                    )
                    .background(Color.LightGray),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .height(80.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .clickable { /* Handle click */ }
                            .background(Color.White)
                            .padding(10.dp)
                            .fillMaxWidth()
                    ){
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter)) {
                            Text(text = "Jadwal: Selasa, 24 - 06 - 2024")
                            Text(text = "Agenda: Khitanan Bobby Aldiansyah")
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier
                    .height(20.dp) // Sesuaikan dengan jarak yang diinginkan
                    .fillMaxWidth()
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomStart = 20.dp,
                            bottomEnd = 20.dp
                        )
                    )
                    .background(Color.LightGray),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .height(80.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .clickable { /* Handle click */ }
                            .background(Color.White)
                            .padding(10.dp)
                            .fillMaxWidth()
                    ){
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter)) {
                            Text(text = "Jadwal: Rabu, 25 - 06 - 2024")
                            Text(text = "Agenda: Pernikahan Rani dan Riko")
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier
                    .height(20.dp) // Sesuaikan dengan jarak yang diinginkan
                    .fillMaxWidth()
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomStart = 20.dp,
                            bottomEnd = 20.dp
                        )
                    )
                    .background(Color.LightGray),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .height(80.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .clickable { /* Handle click */ }
                            .background(Color.White)
                            .padding(10.dp)
                            .fillMaxWidth()
                    ){
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter)) {
                            Text(text = "Jadwal: Kamis, 26 - 06 - 2024")
                            Text(text = "Agenda: Rapat Musyawarah Desa")
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier
                    .height(20.dp) // Sesuaikan dengan jarak yang diinginkan
                    .fillMaxWidth()
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomStart = 20.dp,
                            bottomEnd = 20.dp
                        )
                    )
                    .background(Color.LightGray),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .height(80.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .clickable { /* Handle click */ }
                            .background(Color.White)
                            .padding(10.dp)
                            .fillMaxWidth()
                    ){
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter)) {
                            Text(text = "Jadwal: Jumat, 27 - 06 - 2024")
                            Text(text = "Agenda: Khitanan Reza Gunawan")
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier
                    .height(20.dp) // Sesuaikan dengan jarak yang diinginkan
                    .fillMaxWidth()
            )

            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .background(Color.LightGray)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .clickable { /* Handle click */ },
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60 .dp)
                        .padding(10. dp)
                )
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
