package com.snakes.moviekz.apis

import com.snakes.moviekz.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey:String
    ):Response<MovieResponse>
}