package com.vickikbt.comix.data.api

import com.vickikbt.comix.data.model.Characters
import com.vickikbt.comix.util.EnviromentVariables.Companion.hash
import com.vickikbt.comix.util.EnviromentVariables.Companion.publicKey
import com.vickikbt.comix.util.EnviromentVariables.Companion.ts
import retrofit2.http.GET


interface ApiService {


    @GET("v1/public/characters?ts=$ts&apikey=$publicKey&hash=$hash")
    suspend fun getCharacters(): Characters
}