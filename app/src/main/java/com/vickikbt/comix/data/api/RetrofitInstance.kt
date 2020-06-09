package com.vickikbt.comix.data.api

import com.google.gson.GsonBuilder
import com.vickikbt.comix.util.EnviromentVariables.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }

        val retrofitService = RetrofitInstance.getRetrofitInstance().create(ApiService::class.java)
    }

}