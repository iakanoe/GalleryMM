package io.github.iakanoe.gallery.ui.album

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.iakanoe.gallery.domain.model.Album
import io.github.iakanoe.gallery.usecase.FillAlbumWithPhotosUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val fillAlbumWithPhotosUseCase: FillAlbumWithPhotosUseCase
) : ViewModel() {

    private val state = MutableStateFlow<State>(State.Loading)
    fun getState() = state as StateFlow<State>

    fun loadAlbum(album: Album) = viewModelScope.launch(Dispatchers.IO) {
        state.value = State.Loading
        try {
            val newAlbum = fillAlbumWithPhotosUseCase(album)
            state.value = State.Success(newAlbum)
        } catch (e: Exception) {
            state.value = State.Error
        }
    }

    sealed class State {
        object Loading : State()
        data class Success(val album: Album) : State()
        object Error : State()
    }
}