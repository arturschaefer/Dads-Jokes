package com.schaefer.dadsjokes.data.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

internal class RequestInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()

        return chain.proceed(request)
    }
}