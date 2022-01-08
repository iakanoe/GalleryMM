package io.github.iakanoe.gallery.ui.collection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.iakanoe.gallery.domain.model.Album
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel @Inject constructor() : ViewModel() {
    private val state = MutableStateFlow<State>(State.Success(emptyList()))
    fun getState() = state as StateFlow<State>

    fun loadCollection() = viewModelScope.launch(Dispatchers.IO) {
        state.value = State.Loading
        delay(1500)
        state.value = State.Error
        delay(1500)
        state.value = State.Loading
        delay(1500)
        state.value = State.Success(listOf(Album(id = 1, title = "test album", photos = emptyList())))
    }

    sealed class State {
        object Loading : State()
        data class Success(val collection: List<Album>) : State()
        object Error : State()
    }
}