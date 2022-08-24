package com.schaefer.dadsjokes.ui.home

import com.schaefer.dadsjokes.domain.model.Joke

internal data class HomeState(
    val joke: Joke? = null,
    val loading: Boolean = false
)