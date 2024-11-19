package com.example.pam8_118.ui.viewmodel

import com.example.pam8_118.ui.model.Mahasiswa
import com.example.pam8_118.ui.model.MataKuliah
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(Mahasiswa())
    val uiState: StateFlow<Mahasiswa> = _uiState.asStateFlow()


    private val _mataKuliahState = MutableStateFlow(MataKuliah())  // Initialize with MataKuliah()
    val mataKuliahState: StateFlow<MataKuliah> = _mataKuliahState.asStateFlow()


    fun saveDataSiswa(ls: List<String>) {
        _uiState.update { currentState ->
            currentState.copy(
                nim = ls[0],
                nama = ls[1],
                email = ls[2]
            )
        }
    }


    fun saveMataKuliahData(data: MataKuliah) {
        _mataKuliahState.update { currentState ->
            currentState.copy(
                kelas = data.kelas,
                mataKuliah = data.mataKuliah
            )
        }
    }
}
