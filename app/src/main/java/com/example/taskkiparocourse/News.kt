package com.example.taskkiparocourse

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class News(
    @Json(name = "name")
    val name: String,
    @Json(name = "location")
    val location: String,
    @Json(name = "news")
    val news: List<Publication>
)
