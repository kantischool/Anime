package com.event.anime.state

import com.event.anime.model.item.Anime
import com.event.anime.model.item.AnimeData

data class AnimeDetailState(
    val isLoading: Boolean = false,
    val anime: AnimeData? = null,
    val snackBarMessage: String = "",
    val animeId: Int = 0
)

sealed class AnimeDetailUiEvent() {
    data class GetAnimeDetail(val animeId: Int) : AnimeDetailUiEvent()
}
