package io.github.iakanoe.gallery.usecase

import io.github.iakanoe.gallery.domain.model.Album
import io.github.iakanoe.gallery.domain.repository.AlbumRepository
import javax.inject.Inject

class GetAlbumListUseCase @Inject constructor(private val albumRepository: AlbumRepository) {
    suspend operator fun invoke(): List<Album> {
        return albumRepository.getAllEmpty()
    }
}