package com.example.taskkiparocourse

import com.example.taskkiparocourse.retrofit.SuperNewsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val client: OkHttpClient = OkHttpClient()

const val jsonFileUrl = "https://api2.kiparo.com/"
const val xmlFileUrl = "https://api2.kiparo.com/static/it_news.xml"

fun main() {
    println("Нажмите 1, чтобы скачать JSON, 2 - XML")
    when (readLine()) {
        "1" -> getSuperNews()
        "2" -> print("x == 2")
        else -> {
            print("Введенное значение отлично от 1 и 2")
        }
    }
}

fun getSuperNews() {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient
        .Builder()
        .addInterceptor(interceptor)
        .build()

    val retrofit = Retrofit
        .Builder()
        .baseUrl(jsonFileUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val superNewsApi = retrofit.create(SuperNewsApi::class.java)

    CoroutineScope(Dispatchers.IO).launch {
        val superNews = superNewsApi.getNewsById()
        println(superNews)
    }
}

fun interceptor() {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
}

////парсинг загруженного json файла
//@OptIn(ExperimentalStdlibApi::class)
//fun loadJsonFile() {
//    val jsonFile = getRequest(jsonFileUrl)
//    val moshi: Moshi = Moshi.Builder().build()
//    val jsonAdapter: JsonAdapter<SuperNews> = moshi.adapter()
//
//    val news = jsonFile?.let { jsonAdapter.fromJson(it) }
//    println(news)
//}
//
////загрузка файла
//private fun getRequest(sUrl: String): String? {
//    var result: String? = null
//    try {
//        // Create URL
//        val url = URL(sUrl)
//        // Build request
//        val request = Request.Builder().url(url).build()
//        // Execute request
//        val response = client.newCall(request).execute()
//        result = response.body?.string()
//    } catch (err: Error) {
//        print("Error when executing get request: " + err.localizedMessage)
//    }
//    return result
//}