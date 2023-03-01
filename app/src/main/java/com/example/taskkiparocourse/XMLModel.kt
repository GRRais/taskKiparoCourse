package com.example.taskkiparocourse

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "root")
data class XMLModel(
    @Element(name = "location")
    var location: String?,
    @Element(name = "name")
    var name: String?,
    @Element(name = "news")
    var news: List<NewsXML>?
)

@Root(name = "element")
data class NewsXML(
    @Element(name = "id")
    var id: Int?,
    @Element(name = "title")
    var title: String?,
    @Element(name = "description")
    var description: String?,
    @Element(name = "date")
    var date: String?,
    @Element(name = "keywords")
    var keywords: List<String>?,
    @Element(name = "visible")
    var visible: Boolean?
)

@Root(name = "task")
class Task {
    @Element(name = "id")
    private val id: Long = 0

    @Element(name = "title")
    private val title: String? = null

    @Element(name = "description")
    private val description: String? = null

    @Attribute(required = false)
    private val link: String? = null
}