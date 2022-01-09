package io.github.iakanoe.gallery.usecase

import io.github.iakanoe.gallery.domain.model.Album
import io.github.iakanoe.gallery.domain.repository.AlbumRepository
import javax.inject.Inject

class FillAlbumWithPhotosUseCase @Inject constructor(private val albumRepository: AlbumRepository) {
    suspend operator fun invoke(album: Album): Album {
        val photos = albumRepository.getAlbumPhotos(album)
        return Album(album.id, album.title, photos)
    }
}