package io.github.iakanoe.gallery.data.repository

import io.github.iakanoe.gallery.data.api.AlbumAPI
import io.github.iakanoe.gallery.domain.model.Album
import io.github.iakanoe.gallery.domain.repository.AlbumRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(private val api: AlbumAPI) : AlbumRepository {

    override fun getAll(): Flow<Album> = flow {
        api.getAll().forEach { dto ->
            emit(Album(id = dto.id, title = dto.title, photos = emptyList()))
        }
    }
}