package com.example.watchlist.data

import com.example.watchlist.data.network.RetrofitInstance
import kotlinx.coroutines.flow.Flow

class MovieRepository(private val dao: MovieDao) {

    val allMovies: Flow<List<Movie>> = dao.getAllMovies()

    suspend fun insert(movie: Movie) {
        dao.insertMovie(movie)
    }

    suspend fun update(movie: Movie) {
        dao.updateMovie(movie)
    }

    suspend fun delete(movie: Movie) {
        dao.deleteMovie(movie)
    }

    suspend fun fetchPosterUrl(title: String, genre: String): String? {
        return try {
            val response = if (genre == "Movie") {
                RetrofitInstance.api.searchMovie(RetrofitInstance.API_KEY, title)
            } else {
                RetrofitInstance.api.searchTv(RetrofitInstance.API_KEY, title)
            }
            val path = response.results.firstOrNull()?.poster_path
            path?.let { "https://image.tmdb.org/t/p/w500$it" }
        } catch (e: Exception) {
            null
        }
    }
}