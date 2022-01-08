package io.github.iakanoe.gallery.ui.collection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.iakanoe.gallery.domain.model.Album
import io.github.iakanoe.gallery.usecase.GetAlbumListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel @Inject constructor(
    private val getAlbumListUseCase: GetAlbumListUseCase
) : ViewModel() {

    private val state = MutableStateFlow<State>(State.Success(emptyList()))
    fun getState() = state as StateFlow<State>

    fun loadCollection() = viewModelScope.launch(Dispatchers.IO) {
        state.value = State.Loading
        try {
            val list = getAlbumListUseCase()
            state.value = State.Success(list)
        } catch (e: Exception) {
            state.value = State.Error
        }
    }

    sealed class State {
        object Loading : State()
        data class Success(val collection: List<Album>) : State()
        object Error : State()
    }
}