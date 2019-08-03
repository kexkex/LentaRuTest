package ru.tomindapps.lentarutest.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsModel(
    @PrimaryKey val id: String,
    val title: String,
    val modifiied: Long,
    val link: String
)