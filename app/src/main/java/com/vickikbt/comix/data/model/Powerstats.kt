package com.vickikbt.comix.data.model


import com.google.gson.annotations.SerializedName

data class Powerstats(
    val combat: Int,
    val durability: Int,
    val intelligence: Int,
    val power: Int,
    val speed: Int,
    val strength: Int
)