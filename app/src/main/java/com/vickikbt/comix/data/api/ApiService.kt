package com.vickikbt.comix.data.api

import com.vickikbt.comix.data.model.Characters
import com.vickikbt.comix.util.EnviromentVariables.Companion.hash
import com.vickikbt.comix.util.EnviromentVariables.Companion.limit
import com.vickikbt.comix.util.EnviromentVariables.Companion.offset
import com.vickikbt.comix.util.EnviromentVariables.Companion.publicKey
import com.vickikbt.comix.util.EnviromentVariables.Companion.ts
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    //TODO: Increase the limit of characters called.
    //TODO: Change the GET url to Query format.

    @GET("v1/public/characters?ts=$ts&apikey=$publicKey&hash=$hash&limit=$limit")
    suspend fun getCharacters(): Response<Characters>
}