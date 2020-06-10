package com.vickikbt.comix.repository

import com.vickikbt.comix.data.api.RetrofitInstance

class CharacterRepository {
    private val retrofitInstance = RetrofitInstance.retrofitService

    suspend fun getData() = retrofitInstance.getCharacters()
}