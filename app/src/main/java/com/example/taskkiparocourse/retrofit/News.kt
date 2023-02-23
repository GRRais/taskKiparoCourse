package com.example.taskkiparocourse.retrofit

import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class News(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("date")
    val date: String?,
    @SerializedName("keywords")
    val keywords: List<String>?,
    @SerializedName("visible")
    val visible: Boolean?
)
