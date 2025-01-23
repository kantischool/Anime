package com.event.anime.state

import com.event.anime.model.item.Anime

data class AnimeState(
    val isLoading: Boolean = false,
    val animeList: List<Anime> = emptyList(),
    val snackBarMessage: String = ""
)

sealed class AnimeUiScreenEvent() {

}
