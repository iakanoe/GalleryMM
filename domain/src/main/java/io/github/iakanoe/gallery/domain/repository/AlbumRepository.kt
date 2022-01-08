package io.github.iakanoe.gallery.domain.repository

import io.github.iakanoe.gallery.domain.model.Album
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {
    fun getAll(): Flow<Album>
}