package com.example.pam8_118.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
            }
        }
    }
}

