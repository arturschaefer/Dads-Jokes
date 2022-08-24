package com.schaefer.dadsjokes.data.api

import com.schaefer.dadsjokes.data.api.dto.toDomain
import com.schaefer.dadsjokes.domain.DadsJokesRepository
import com.schaefer.dadsjokes.domain.model.Joke
import javax.inject.Inject

internal class DadsJokesRepositoryImpl @Inject constructor(
    private val service: DadsJokesService,
) : DadsJokesRepository {

    override suspend fun getRandomJoke(): Joke? {
        val result = service.getRandomJoke()

        return if (result.isSuccessful) {
            result.body()?.toDomain()
        } else {
            null
        }
    }
}