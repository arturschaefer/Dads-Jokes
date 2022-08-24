package com.schaefer.dadsjokes.data.api

import javax.inject.Inject

internal class DadsJokesRepository @Inject constructor(
    private val service: DadsJokesService,
) {
    fun getRandomJoke(){
        val result = service.getRandomJoke()

        return
    }
}