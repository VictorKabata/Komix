package com.vickikbt.comix.data.model


import com.google.gson.annotations.SerializedName

data class Biography(
    val aliases: List<String>,
    val alignment: String,
    val fullName: String,
    val placeOfBirth: String
)