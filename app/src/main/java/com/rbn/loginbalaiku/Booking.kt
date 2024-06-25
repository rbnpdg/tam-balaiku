package com.rbn.loginbalaiku

import android.util.Log
import android.widget.Toast
import android.app.DatePickerDialog
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

data class BookingKu(
    val nama: String,
    val email: String,
    val checkInDate: String,
    val checkOutDate: String,
    val agenda: String
)

@Composable
fun BookingForm(navController: NavController, modifier: Modifier = Modifier) {
    var checkInDate by remember { mutableStateOf<String?>(null) }
    var checkOutDate by remember { mutableStateOf<String?>(null) }
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var agenda by remember { mutableStateOf("") }
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val dateFormat = remember { SimpleDateFormat("dd - MM - yyyy", Locale.getDefault()) }

    val checkInDatePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            checkInDate = "$dayOfMonth - ${month + 1} - $year"
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)
    )

    // DatePickerDialog for Check-out Date
    val checkOutDatePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            checkOutDate = "$dayOfMonth - ${month + 1} - $year"
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)
    )

    Scaffold(
        bottomBar = { Bar(navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF1F5F8))
                .padding(innerPadding)
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.logo_balaiku),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .offset(y = 2.dp),
                    alignment = Alignment.Center
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Center)
            ) {
                Column(
                    modifier = Modifier
                        .width(400.dp)
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally),
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
                        // Display selected Check-in Date
                        OutlinedTextField(
                            value = checkInDate ?: "",
                            onValueChange = { /* No action needed here */ },
                            readOnly = true,
                            label = { Text("Check In") },
                            modifier = Modifier
                                .weight(1f)
                                .clickable { checkInDatePickerDialog.show() }
                                .padding(vertical = 16.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        // Display selected Check-out Date
                        OutlinedTextField(
                            value = checkOutDate ?: "",
                            onValueChange = { /* No action needed here */ },
                            readOnly = true,
                            label = { Text("Check Out") },
                            modifier = Modifier
                                .weight(1f)
                                .clickable { checkOutDatePickerDialog.show() }
                                .padding(vertical = 16.dp)
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
                        onClick = {
                            // Buat instance dari Booking
                            val booking = BookingKu(
                                nama = nama,
                                email = email,
                                checkInDate = checkInDate ?: "",
                                checkOutDate = checkOutDate ?: "",
                                agenda = agenda
                            )

                            // Simpan data ke Firebase
                            val database = FirebaseDatabase.getInstance()
                            val myRef = database.getReference("bookings")
                            val newBookingRef = myRef.push()
                            newBookingRef.setValue(booking)
                                .addOnSuccessListener {
                                    // Jika berhasil disimpan
                                    Toast.makeText(context, "Booking confirmed", Toast.LENGTH_SHORT).show()
                                    navController.navigate("jadwal")
                                }
                                .addOnFailureListener {
                                    // Jika gagal disimpan
                                    Toast.makeText(context, "Failed to save booking: ${it.message}", Toast.LENGTH_SHORT).show()
                                }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF164863))
                    ) {
                        Text(text = "CONFIRM", color = Color.White)
                    }
                }
            }
        }
    }
}
