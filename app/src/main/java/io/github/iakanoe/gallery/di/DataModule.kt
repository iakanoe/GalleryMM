package io.github.iakanoe.gallery.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.iakanoe.gallery.data.repository.AlbumRepositoryImpl
import io.github.iakanoe.gallery.domain.repository.AlbumRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindAlbumRepository(impl: AlbumRepositoryImpl): AlbumRepository
}