package com.event.anime.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.event.anime.api.ResponseState
import com.event.anime.model.item.AnimeData
import com.event.anime.repository.AppRepository
import com.event.anime.state.AnimeDetailState
import com.event.anime.state.AnimeDetailUiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    private val appRepository: AppRepository
) : ViewModel() {

    private val uiState = MutableStateFlow(AnimeDetailState())
    fun consumableState() = uiState.asStateFlow()

    fun onEvent(event: AnimeDetailUiEvent) {
        when (event) {
            is AnimeDetailUiEvent.GetAnimeDetail -> {
                animeDetail(event.animeId)
            }
        }
    }

    private fun animeDetail(animeId: Int) {
        appRepository.animeDetail(animeId).onEach { response ->
            when (response) {
                is ResponseState.Loading -> {
                    uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }

                is ResponseState.Success -> {
                    uiState.update {
                        it.copy(
                            isLoading = false,
                            anime = AnimeData(
                                anime = response.data?.data,
                                genres = response.data?.data?.genres?.joinToString { it.name.toString() }
                            )
                        )
                    }
                }

                is ResponseState.Error -> {
                    showSnackBar(response.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun showSnackBar(snackBarMessage: String) {
        uiState.update { it.copy(snackBarMessage = snackBarMessage) }
        dismissSnackBar()
    }

    private fun dismissSnackBar() {
        viewModelScope.launch {
            delay(1000)
            uiState.update { it.copy(snackBarMessage = "") }
        }
    }
}
