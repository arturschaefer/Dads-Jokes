package com.schaefer.dadsjokes.data.api

import com.schaefer.dadsjokes.data.api.dto.JokeDTO
import retrofit2.Response
import retrofit2.http.GET

internal interface DadsJokesApi {
    @GET("/")
    suspend fun getRandomJoke(): Response<JokeDTO>
}