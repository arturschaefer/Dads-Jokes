package com.schaefer.dadsjokes.data.api.dto

import androidx.annotation.Keep
import com.schaefer.dadsjokes.domain.model.Joke

@Keep
internal data class JokeDTO(
    val id: String? = null,
    val joke: String? = null,
    val status: Int? = null,
)

internal fun JokeDTO.toDomain(): Joke {
    return Joke(
        id = id.orEmpty(),
        joke = joke.orEmpty(),
        status = status ?: Int.MIN_VALUE,
    )
}