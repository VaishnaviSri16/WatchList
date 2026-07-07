package com.example.watchlist.viewmodel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.watchlist.data.DatabaseProvider
import com.example.watchlist.data.Movie
import com.example.watchlist.data.MovieRepository
import com.example.watchlist.ui.theme.FilterType
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MovieRepository

    private val _filter = MutableStateFlow(FilterType.ALL)
    val filter: StateFlow<FilterType> = _filter

    val movies: StateFlow<List<Movie>>

    init {
        val dao = DatabaseProvider.getDatabase(application).movieDao()
        repository = MovieRepository(dao)

        movies = combine(repository.allMovies, _filter) { list, currentFilter ->
            when (currentFilter) {
                FilterType.ALL -> list
                FilterType.WATCHING -> list.filter { !it.isWatched }
                FilterType.COMPLETED -> list.filter { it.isWatched }
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    }


    fun addMovie(title: String, genre: String, rating: Int) {
        viewModelScope.launch {
            val posterUrl = repository.fetchPosterUrl(title, genre)
            repository.insert(Movie(title = title, genre = genre, rating = rating, posterUrl = posterUrl))
        }
    }

    fun toggleWatched(movie: Movie) {
        viewModelScope.launch {
            repository.update(movie.copy(isWatched = !movie.isWatched))
        }
    }

    fun deleteMovie(movie: Movie) {
        viewModelScope.launch {
            repository.delete(movie)
        }
    }

    fun setFilter(newFilter: FilterType) {
        _filter.value = newFilter
    }
}