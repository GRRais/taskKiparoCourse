package com.example.taskkiparocourse

import com.google.gson.annotations.SerializedName

data class JSONModel(
    var name: String?,
    var location: String?,
    var news: List<News>?
)

data class News(
    @SerializedName("id")
    var id: Int?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("date")
    var date: String?,
    @SerializedName("keywords")
    var keywords: List<String>?,
    @SerializedName("visible")
    var visible: Boolean?
)