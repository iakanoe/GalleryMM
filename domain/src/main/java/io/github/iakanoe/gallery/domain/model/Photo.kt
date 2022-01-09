package io.github.iakanoe.gallery.domain.model

import java.io.Serializable

data class Photo(
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) : Serializable