package com.schaefer.dadsjokes.data.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

private const val BASE_URL = "https://icanhazdadjoke.com/"

@Singleton
internal class RetrofitProvider @Inject constructor(
    private val okHttpClientProvider: OkHttpClientProvider,
) {
    private val retrofit: Retrofit by lazy { createRetrofit() }

    fun retrofit() = retrofit

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClientProvider.client())
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}