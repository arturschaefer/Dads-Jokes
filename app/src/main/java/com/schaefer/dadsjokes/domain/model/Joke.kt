package com.schaefer.dadsjokes.domain.model

internal data class Joke(
    val id: String,
    val joke: String,
    val status: Int,
)