package com.example.watchlist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val genre: String,
    val rating: Int,
    val isWatched: Boolean = false,
    val posterUrl: String? = null
)