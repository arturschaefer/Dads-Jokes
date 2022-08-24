package com.schaefer.dadsjokes.di

import com.schaefer.dadsjokes.data.api.DadsJokesApi
import com.schaefer.dadsjokes.data.api.DadsJokesRepositoryImpl
import com.schaefer.dadsjokes.data.api.DadsJokesService
import com.schaefer.dadsjokes.data.network.RetrofitProvider
import com.schaefer.dadsjokes.domain.DadsJokesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DadsJokesModule {

    @Provides
    fun provideDadsJokesApi(retrofitProvider: RetrofitProvider): DadsJokesApi =
        retrofitProvider.retrofit().create(
            DadsJokesApi::class.java
        )

    @Provides
    fun provideDadsJokesRepository(service: DadsJokesService): DadsJokesRepository =
        DadsJokesRepositoryImpl(service)
}