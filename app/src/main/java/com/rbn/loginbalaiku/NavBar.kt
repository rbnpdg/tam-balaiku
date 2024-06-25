package com.rbn.loginbalaiku

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Bar(navController: NavController){
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