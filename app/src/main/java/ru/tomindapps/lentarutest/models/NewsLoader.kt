package ru.tomindapps.lentarutest.models

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.github.rybalkinsd.kohttp.ext.asString
import io.github.rybalkinsd.kohttp.ext.httpGet

object NewsLoader {

    private const val BASE_URL = "https://api.lenta.ru/"
    private const val GET_URL = "lists/latest"

    fun load() = castToNews()

    private fun castToNews(): ArrayList<NewsModel>{
        val arrApi = parseJson()
        var arrNews = ArrayList<NewsModel>()
        for (a in arrApi) arrNews.add(
            NewsModel(
            a.info.id,
            a.info.title,
            a.info.modified,
            a.links.public
        )
        )
        return arrNews
    }

    private fun getJson(): String? {
        val url = BASE_URL + GET_URL
        val response = url.httpGet()
        return response.asString()
    }

    private fun parseJson(): ArrayList<NewsApiClass> {
        val gson = Gson()
        val type = object: TypeToken<HeadlinesApiClass>(){}.type
        val fromJson = gson.fromJson(getJson(),type) as HeadlinesApiClass
        return fromJson.headlines
    }
}