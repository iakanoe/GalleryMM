package io.github.iakanoe.gallery.data.dto

import com.google.gson.annotations.SerializedName

data class PhotoDTO(
    @SerializedName("userId") val albumId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String,
    @SerializedName("thumbnailUrl") val thumbnailUrl: String
)
