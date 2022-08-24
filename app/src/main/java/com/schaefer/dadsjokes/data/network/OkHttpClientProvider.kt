package com.schaefer.dadsjokes.data.network

import com.schaefer.dadsjokes.data.network.interceptors.HttpInterceptor
import com.schaefer.dadsjokes.data.network.interceptors.RequestInterceptor
import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class OkHttpClientProvider @Inject constructor(
    private val requestInterceptor: RequestInterceptor,
    private val httpInterceptor: HttpInterceptor,
){
    private val okHttpClient: OkHttpClient by lazy { createOkHttp() }

    fun client() = okHttpClient

    private fun createOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(httpInterceptor.getLogging())
            .build();
    }
}
