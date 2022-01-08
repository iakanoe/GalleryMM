package io.github.iakanoe.gallery.data.api

import io.github.iakanoe.gallery.data.dto.AlbumDTO
import retrofit2.http.GET

interface AlbumAPI {
    @GET("/albums")
    suspend fun getAll(): List<AlbumDTO>
}