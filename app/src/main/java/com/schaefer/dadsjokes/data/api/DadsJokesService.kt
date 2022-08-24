package com.schaefer.dadsjokes.data.api

import com.schaefer.dadsjokes.data.api.dto.JokeDTO
import com.schaefer.dadsjokes.data.network.RetrofitProvider
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DadsJokesService @Inject constructor(
    private val api: DadsJokesApi,
) {
    suspend fun getRandomJoke(): Response<JokeDTO> = api.getRandomJoke()
}