package com.example.pam8_118.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam8_118.R


@Composable
fun MataKuliahFormView(
    mahasiswaData: List<String>,
    onSubmitButtonClicked: (Map<String, String>) -> Unit
) {
    var kelass by remember { mutableStateOf("") }
    var mataKuliah by remember { mutableStateOf("") }

    val mataKuliahOptions = listOf("AI TERAPAN", "ANALISIS BIG DATA", "COMPUTER VISION")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.primary))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(id = R.color.primary),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Image(
                    painter = painterResource(id = R.drawable.college),
                    contentDescription = "Mahasiswa Image",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.size(16.dp))

                // Text "Data Mahasiswa"
                Text(
                    text = "Data Mahasiswa",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = White
                )
            }
        }

        Spacer(modifier = Modifier.size(16.dp))


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = White,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(20.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(horizontalAlignment = Alignment.Start, modifier = Modifier.weight(1f)) {
                    Text(text = "NIM: ${mahasiswaData[0]}")
                    Text(text = "Nama: ${mahasiswaData[1]}")
                }
                Text(text = "Email: ${mahasiswaData[2]}", modifier = Modifier.weight(1f), textAlign = TextAlign.Right)
            }

            Spacer(modifier = Modifier.size(16.dp))

            // Kelas Input
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = kelass,
                onValueChange = { kelass = it },
                label = { Text(text = "Kelas") },
                singleLine = true
            )
            Spacer(modifier = Modifier.size(16.dp))

            // Mata Kuliah Radio Button
            Text(text = "Pilih Mata Kuliah:")
            Column {
                mataKuliahOptions.forEach { option ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        androidx.compose.material3.RadioButton(
                            selected = mataKuliah == option,
                            onClick = { mataKuliah = option }
                        )
                        Text(
                            text = option,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.size(16.dp))

            // Submit Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    onSubmitButtonClicked(
                        mapOf(
                            "kelas" to kelass,
                            "mataKuliah" to mataKuliah
                        )
                    )
                }) {
                    Text(text = "Submit")
                }
            }
        }
    }
}
