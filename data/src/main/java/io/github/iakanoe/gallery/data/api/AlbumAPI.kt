package io.github.iakanoe.gallery.data.api

import io.github.iakanoe.gallery.data.dto.AlbumDTO
import io.github.iakanoe.gallery.data.dto.PhotoDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumAPI {
    @GET("/albums")
    suspend fun getAll(): List<AlbumDTO>

    @GET("/albums/{id}/photos")
    suspend fun getPhotos(@Path("id") id: Int): List<PhotoDTO>
}