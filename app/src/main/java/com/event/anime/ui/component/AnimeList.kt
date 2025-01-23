package com.event.anime.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.event.anime.extension.disableSplitMotionEvents
import com.event.anime.model.item.Anime
import com.event.anime.ui.item.AnimeItem

@Composable
fun AnimeList(
    animeList: () -> List<Anime> = { emptyList() },
    onAnimeClick: (Int) -> Unit = {},
) {
    LazyVerticalGrid(
        modifier = Modifier.disableSplitMotionEvents(),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        this.items(animeList()) { anime ->
            AnimeItem(
                anime = anime,
                onAnimeClick = onAnimeClick
            )
        }
    }
}