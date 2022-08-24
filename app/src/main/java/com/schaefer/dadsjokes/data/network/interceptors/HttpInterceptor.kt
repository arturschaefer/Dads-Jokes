package com.schaefer.dadsjokes.data.network.interceptors

import com.schaefer.dadsjokes.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class HttpInterceptor @Inject constructor() {

    fun getLogging(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(
            getLoggingLevel()
        )
    }

    private fun getLoggingLevel(): HttpLoggingInterceptor.Level {
        return if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }
}