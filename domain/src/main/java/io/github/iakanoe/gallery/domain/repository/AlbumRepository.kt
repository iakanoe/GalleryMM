package io.github.iakanoe.gallery.domain.repository

import io.github.iakanoe.gallery.domain.model.Album
import io.github.iakanoe.gallery.domain.model.Photo

interface AlbumRepository {
    suspend fun getAllEmpty(): List<Album>
    suspend fun getAlbumPhotos(album: Album): List<Photo>
}