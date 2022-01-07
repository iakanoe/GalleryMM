package io.github.iakanoe.gallery.domain.model

data class Album(
    val id: Int,
    val title: String,
    val photos: List<Photo>
)