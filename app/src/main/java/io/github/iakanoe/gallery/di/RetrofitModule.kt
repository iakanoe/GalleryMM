package io.github.iakanoe.gallery.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.iakanoe.gallery.data.api.AlbumAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private const val API_URL = "https://jsonplaceholder.typicode.com"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideAlbumAPI(retrofit: Retrofit) = retrofit.create(AlbumAPI::class.java)
}