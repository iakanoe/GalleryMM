package io.github.iakanoe.gallery.domain.model

import java.io.Serializable

data class Album(
    val id: Int,
    val title: String,
    val photos: List<Photo>
) : Serializable