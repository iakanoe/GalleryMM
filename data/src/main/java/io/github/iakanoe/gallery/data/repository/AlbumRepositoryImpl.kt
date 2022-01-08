package io.github.iakanoe.gallery.data.repository

import io.github.iakanoe.gallery.data.api.AlbumAPI
import io.github.iakanoe.gallery.domain.model.Album
import io.github.iakanoe.gallery.domain.repository.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(private val api: AlbumAPI) : AlbumRepository {

    override suspend fun getAllEmpty(): List<Album> {
        return api.getAll().map { dto ->
            Album(id = dto.id, title = dto.title, photos = emptyList())
        }
    }
}