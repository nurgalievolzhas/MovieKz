package com.snakes.moviekz.remote

import com.snakes.moviekz.MovieResponse
import com.snakes.moviekz.apis.MovieApi
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val movieApi: MovieApi
) {
    suspend fun getPopularMovies(apiKey:String):Response<MovieResponse>{
        return movieApi.getPopularMovies(apiKey)
    }
}