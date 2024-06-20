package com.rbn.loginbalaiku

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomePage(navController: NavController, modifier: Modifier = Modifier){
    Box(modifier = Modifier
        .background(Color.White)
        .fillMaxSize()){
        Column (
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ){

            Image(painter = painterResource(id = R.drawable.logo_balaiku), contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .offset(y = 2.dp), alignment = Alignment.Center)

            Spacer(modifier = Modifier.height(30.dp))

            Image(painter = painterResource(id = R.drawable.balai_desa), contentDescription = "Balai")

            Spacer(modifier = Modifier.height(30.dp))

            Image(painter = painterResource(id = R.drawable.balai), contentDescription = "Balai")
            Spacer(modifier = Modifier.height(30.dp))


            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(start = 10.dp, end = 10.dp)
                .clip(
                    RoundedCornerShape(20.dp
                    )
                )){
                Row {
                    Text(
                        text = "BalaiKu adalah aplikasi inovatif yang dirancang untuk mempermudah warga dalam memesan dan mengatur penggunaan balai desa."
                        , modifier = Modifier.padding(10.dp))
                }

            }


            Spacer(modifier = Modifier.height(100.dp))

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
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(id = R.drawable.booking),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp)
                    .clickable { navController.navigate("Booking") }
            )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(id = R.drawable.schedule),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp)
                    .clickable { navController.navigate("jadwal") }
            )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp)
                    .clickable { navController.navigate("profile") }
            )
        }
    }



}

