package ru.tomindapps.lentarutest.database

import androidx.room.*
import ru.tomindapps.lentarutest.models.NewsModel

@Dao
interface NewsDao {

    @Insert
    fun insert(newsModel: NewsModel)

    @Delete
    fun delete(newsModel: NewsModel)

    @Update
    fun update(newsModel: NewsModel)

    @Query("Select * from news")
    fun selectAll():List<NewsModel>

    @Query("Select id from news")
    fun selectIds():List<String>



}
