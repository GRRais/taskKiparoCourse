package com.example.taskkiparocourse

import com.google.gson.annotations.SerializedName
import org.simpleframework.xml.Root

@Root(name = "data", strict = false)
data class XMLModel(
    var name: String?,
    var location: String?,
    var news: List<NewsXML>?
)

data class NewsXML(
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