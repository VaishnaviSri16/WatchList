package com.example.watchlist.data.network


data class TmdbSearchResponse(
    val results: List<TmdbMovieResult>
)

data class TmdbMovieResult(
    val id: Int,
    val title: String?,
    val name: String?,
    val poster_path: String?
)