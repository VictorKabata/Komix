package com.vickikbt.comix.data.model


import com.google.gson.annotations.SerializedName

data class Characters(
    val `data`: Data,
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val etag: String,
    val status: String
)