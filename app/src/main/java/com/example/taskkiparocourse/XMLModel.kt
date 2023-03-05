package com.example.taskkiparocourse

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name="root", strict = false)
data class XMLModel (
    @field:Element(name = "location") @param:Element(name = "location")
    var location: String?,
    @field:Element(name = "name") @param:Element(name = "name")
    var name: String?,
    @field:ElementList(name = "news", inline = true, required = false)
    @param:ElementList(name = "news", inline = true, required = false)
    var news: List<NewsXML>?
)

@Root(name = "element", strict = false)
data class NewsXML(
    @Element(name = "id")
    var id: Int?,
    @Element(name = "title")
    var title: String?,
    @Element(name = "description")
    var description: String?,
    @Element(name = "date")
    var date: String?,
    @ElementList(name = "keywords")
    var keywords: List<String>?,
    @Element(name = "visible")
    var visible: Boolean?
)

