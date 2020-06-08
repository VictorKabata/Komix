package com.vickikbt.comix.data.api

import com.vickikbt.comix.data.model.Characters
import retrofit2.Response
import retrofit2.http.GET

interface CharacterService {

    @GET("all.json")
    suspend fun getCharacters():Response<Characters>
}