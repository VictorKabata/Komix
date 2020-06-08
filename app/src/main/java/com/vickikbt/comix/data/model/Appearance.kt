package com.vickikbt.comix.data.model


import com.google.gson.annotations.SerializedName

data class Appearance(
    val gender: String,
    val height: List<String>,
    val race: Any,
    val weight: List<String>
)