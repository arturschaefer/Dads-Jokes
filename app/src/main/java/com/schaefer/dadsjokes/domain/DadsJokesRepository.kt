package com.schaefer.dadsjokes.domain

import com.schaefer.dadsjokes.domain.model.Joke

internal interface GetRandomJokeUseCase {
    suspend operator fun invoke(): Joke?
}