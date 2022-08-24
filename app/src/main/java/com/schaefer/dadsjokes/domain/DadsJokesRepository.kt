package com.schaefer.dadsjokes.domain

import com.schaefer.dadsjokes.domain.model.Joke

internal interface DadsJokesRepository {
    suspend fun getRandomJoke(): Joke?
}