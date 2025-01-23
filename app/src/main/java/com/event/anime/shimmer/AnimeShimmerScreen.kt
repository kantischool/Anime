package com.event.anime.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.event.anime.extension.shimmerEffect
import com.event.anime.ui.theme.colorGrey

@Composable
fun AnimeShimmerScreen(modifier: Modifier) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(10) {
            AnimeShimmerItem()
        }
    }
}

@Composable
fun AnimeShimmerItem() {
    Box(
        modifier = Modifier
            .heightIn(min = 250.dp)
            .shimmerEffect()
            .background(color = colorGrey, shape = RoundedCornerShape(8.dp))
    )
}