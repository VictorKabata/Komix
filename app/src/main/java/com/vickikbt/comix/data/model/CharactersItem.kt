package com.vickikbt.comix.data.model


data class CharactersItem(
    val name: String,
    val biography: Biography,
    val appearance: Appearance,
    val id: Int,
    val images: Images,
    val powerstats: Powerstats,
    val work: Work
)