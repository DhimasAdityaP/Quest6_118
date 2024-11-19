package com.example.pam8_118.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam8_118.R

@Composable
fun DataMahasiswaView(
    mahasiswaData: List<String> = listOf("123456", "Nama Mahasiswa", "email@example.com"),
    mataKuliah: String = "Mata Kuliah Default",
    kelas: String = "Kelas Default",
    onBackButtonClicked: () -> Unit,
    onResetButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF004029))
            .padding(horizontal = 8.dp)
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF004029))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.college),
                contentDescription = "Mahasiswa",
                modifier = Modifier
                    .size(80.dp)
                    .padding(bottom = 8.dp)
            )

            Text(
                text = "Detail Mahasiswa",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.size(16.dp))


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(50.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "NIM: ${mahasiswaData[0]}", fontSize = 16.sp)
                    Text(
                        text = "Nama: ${mahasiswaData[1]}",
                        fontSize = 16.sp,
                    )
                }
                Text(
                    text = "Email: ${mahasiswaData[2]}",
                    fontSize = 16.sp,
                    textAlign = TextAlign.End
                )
            }

            Spacer(modifier = Modifier.size(16.dp))


            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Mata Kuliah: $mataKuliah",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Kelas: $kelas",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.size(32.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = { onBackButtonClicked() }, modifier = Modifier.weight(1f)) {
                Text(text = "Kembali")
            }
            Button(onClick = { onResetButtonClicked() }, modifier = Modifier.weight(1f)) {
                Text(text = "Reset")
            }
        }
    }
}
