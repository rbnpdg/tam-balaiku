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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.firebase.database.*

data class Booking(
    val nama: String = "",
    val email: String = "",
    val checkInDate: String = "",
    val checkOutDate: String = "",
    val agenda: String = ""
)

class BookingViewModel : ViewModel() {
    private val _bookings = MutableLiveData<List<Booking>>()
    val bookings: LiveData<List<Booking>> = _bookings

    init {
        fetchBookings()
    }

    private fun fetchBookings() {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("bookings")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val bookingList = mutableListOf<Booking>()
                snapshot.children.forEach { dataSnapshot ->
                    val booking = dataSnapshot.getValue(Booking::class.java)
                    if (booking != null) {
                        bookingList.add(booking)
                    }
                }
                _bookings.value = bookingList
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }
}

@Composable
fun Jadwal(navController: NavController, modifier: Modifier = Modifier) {
    val bookingViewModel: BookingViewModel = viewModel()
    val bookings by bookingViewModel.bookings.observeAsState(emptyList())

    Scaffold(
        bottomBar = { Bar(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
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
                items(bookings) { booking ->
                    Column {
                        ScheduleItem(
                            agenda = booking.agenda,
                            checkInDate = booking.checkInDate,
                            checkOutDate = booking.checkOutDate,
                            email = booking.email,
                            nama = booking.nama,
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}


@Composable
fun ScheduleItem(checkInDate: String, checkOutDate: String, agenda: String, nama: String, email: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(10.dp))
            .background(Color.White)
            .padding(10.dp)
    ) {
        Text(text = "Nama: $nama")
        Text(text = "Email: $email")
        Text(text = "Check-in: $checkInDate")
        Text(text = "Check-out: $checkOutDate")
        Text(text = "Agenda: $agenda")
    }
}

