package com.example.appenglish.di

import com.example.appenglish.repository.AudioRepository
import com.example.appenglish.repository.AudioRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun providesAudioRepository( audioRepositoryImpl: AudioRepositoryImpl ): AudioRepository

}