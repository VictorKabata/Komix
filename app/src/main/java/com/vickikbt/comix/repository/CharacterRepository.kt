package com.vickikbt.comix.repository

import com.vickikbt.comix.data.api.RetrofitInstance

class CharacterRepository {
    private val response = RetrofitInstance.retrofitService

    suspend fun getData() = response.getCharacters()
}