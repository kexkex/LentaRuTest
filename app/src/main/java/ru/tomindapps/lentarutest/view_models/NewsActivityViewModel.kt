package ru.tomindapps.lentarutest.view_models

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ru.tomindapps.lentarutest.database.AppDb
import ru.tomindapps.lentarutest.database.NewsRepo
import ru.tomindapps.lentarutest.models.NewsModel

class NewsActivityViewModel(app: Application) : AndroidViewModel(app){

    private val newsRepo: NewsRepo
    var news = MutableLiveData<ArrayList<NewsModel>>()

    init {
        val dao = AppDb.getInstance(app).newsDao()
        newsRepo = NewsRepo(dao, app.applicationContext)
    }

    fun loadNews(){
        DoLoad().execute()
    }

    private inner class DoLoad: AsyncTask<Unit, Unit, ArrayList<NewsModel>>(){
        override fun doInBackground(vararg params: Unit?): ArrayList<NewsModel> {
            return newsRepo.getFromSource()
        }


        override fun onPostExecute(result: ArrayList<NewsModel>?) {
            news.postValue(result)
        }

    }

}