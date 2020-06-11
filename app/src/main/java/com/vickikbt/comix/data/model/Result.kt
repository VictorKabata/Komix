package com.vickikbt.comix.data.model


import com.google.gson.annotations.SerializedName

data class Result(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail,
    val comics: Comics,
    val events: Events,
    val modified: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val urls: List<Url>
)