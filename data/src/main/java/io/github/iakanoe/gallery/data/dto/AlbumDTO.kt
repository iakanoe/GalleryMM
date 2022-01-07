package io.github.iakanoe.gallery.data.dto

import com.google.gson.annotations.SerializedName

data class AlbumDTO(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String
)