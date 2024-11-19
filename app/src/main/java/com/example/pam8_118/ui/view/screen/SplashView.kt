package com.example.pam8_118.ui.view.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun MataKuliahFormView(
    mahasiswaData: List<String>,
    onSubmitButtonClicked: (Map<String, String>) -> Unit
) {
    var kelass by remember { mutableStateOf("") }
    var mataKuliah by remember { mutableStateOf("") }

    val mataKuliahOptions = listOf("AI TERAPAN", "ANALISIS BIG DATA", "COMPUTER VISION")}