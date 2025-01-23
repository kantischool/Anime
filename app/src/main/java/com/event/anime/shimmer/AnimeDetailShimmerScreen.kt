package com.event.anime.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.event.anime.extension.shimmerEffect
import com.event.anime.ui.theme.colorGrey

@Composable
fun AnimeDetailShimmerScreen(modifier: Modifier) {
    Column(modifier= modifier) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(180.dp)
                .shimmerEffect()
                .background(color = colorGrey, shape = RoundedCornerShape(8.dp))
        )

        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .width(120.dp)
                .height(16.dp)
                .shimmerEffect()
                .background(color = colorGrey, shape = RoundedCornerShape(8.dp))
        )

        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .width(80.dp)
                .height(16.dp)
                .shimmerEffect()
                .background(color = colorGrey, shape = RoundedCornerShape(8.dp))
        )

        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .width(40.dp)
                .height(16.dp)
                .shimmerEffect()
                .background(color = colorGrey, shape = RoundedCornerShape(8.dp))
        )

        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .width(40.dp)
                .height(16.dp)
                .shimmerEffect()
                .background(color = colorGrey, shape = RoundedCornerShape(8.dp))
        )

    }
}