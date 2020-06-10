package com.vickikbt.comix.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vickikbt.comix.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    private val repository = CharacterRepository()

    val myData = liveData(Dispatchers.IO) {
        val retrievedCharacters = repository.getData()
        emit(retrievedCharacters)
    }
}