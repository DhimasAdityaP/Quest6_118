package com.example.pam8_118.navigation

import MahasiswaFormView
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam8_118.ui.model.MataKuliah
import com.example.pam8_118.ui.view.screen.DataMahasiswaView
import com.example.pam8_118.ui.view.screen.MataKuliahFormView
import com.example.pam8_118.ui.view.screen.SplashView
import com.example.pam8_118.ui.viewmodel.MahasiswaViewModel

enum class Halaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val mahasiswaState = viewModel.uiState.collectAsState().value // Accessing the value of the state
    val mataKuliahState = viewModel.mataKuliahState.collectAsState().value // Accessing MataKuliah state

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ) {
        composable(route = Halaman.Splash.name) {
            SplashView(onMulaiButton = { navController.navigate(Halaman.Mahasiswa.name) })
        }

        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButtonClicked = { data ->
                    viewModel.saveDataSiswa(data) // Save Mahasiswa data
                    navController.navigate(Halaman.Matakuliah.name) // Navigate to Matakuliah screen
                },
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
    }
}

