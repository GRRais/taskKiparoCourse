package com.example.taskkiparocourse

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL

val client: OkHttpClient = OkHttpClient()
val jsonFile:

fun main() {
    println("Нажмите 1, чтобы скачать JSON, 2 - XML")
    println()
    when(readLine()) {
        "1" -> loadJsonFile()
        "2" -> print("x == 2")
        else -> {
            print("Введенное значение отлично от 1 и 2")
        }
    }
}

@OptIn(ExperimentalStdlibApi::class)
fun loadJsonFile() {
    val jsonFile = "https://api2.kiparo.com/static/it_news.json"
    val moshi: Moshi = Moshi.Builder().build()
    val jsonAdapter: JsonAdapter<Publication> = moshi.adapter()

    val news = jsonAdapter.fromJson(jsonFile)
    println(news)
}

private fun getRequest(sUrl: String): String? {
    var result: String? = null
    try {
        // Create URL
        val url = URL(sUrl)
        // Build request
        val request = Request.Builder().url(url).build()
        // Execute request
        val response = client.newCall(request).execute()
        result = response.body?.string()
    }
    catch(err:Error) {
        print("Error when executing get request: "+err.localizedMessage)
    }
    return result
}