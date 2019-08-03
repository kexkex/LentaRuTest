package ru.tomindapps.lentarutest.database

import android.content.Context
import android.net.ConnectivityManager
import ru.tomindapps.lentarutest.models.NewsLoader
import ru.tomindapps.lentarutest.models.NewsModel

class NewsRepo (val newsDao: NewsDao, val context: Context){


    private fun getFromWeb(): ArrayList<NewsModel> = NewsLoader.load()
    private fun getFromDb(): ArrayList<NewsModel> = newsDao.selectAll() as ArrayList<NewsModel>
    private fun getIdFromDb(): ArrayList<String> = newsDao.selectIds() as ArrayList<String>

    private fun saveLoaded(arr: ArrayList<NewsModel>){
        val arrId = getIdFromDb()
        for (a in arr) if (!arrId.contains(a.id)){
            newsDao.insert(a)
        } else {newsDao.update(a)}
    }

    private fun isNetworkConnected(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    fun getFromSource(): ArrayList<NewsModel>{
        var news: ArrayList<NewsModel>
        return if (isNetworkConnected(context)) {
            news = getFromWeb()
            saveLoaded(news)
            news

        } else {getFromDb()}
    }


}