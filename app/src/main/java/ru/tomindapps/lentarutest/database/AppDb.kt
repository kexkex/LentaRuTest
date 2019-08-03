package ru.tomindapps.lentarutest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.tomindapps.lentarutest.models.NewsModel

@Database (entities = [NewsModel::class], version = 1)
abstract class AppDb :RoomDatabase(){
    abstract fun newsDao(): NewsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDb? = null

        fun getInstance(context: Context): AppDb {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDb::class.java,
                    "News_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}