package com.example.taskkiparocourse

data class NewsCell(
    var id: Int,
    var title: String,
    var description: String,
    var date: String,
    var keywords: List<String>,
    var visible: Boolean
)
