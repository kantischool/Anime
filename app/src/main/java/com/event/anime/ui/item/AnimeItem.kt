package com.event.anime.ui.item

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.event.anime.R
import com.event.anime.comman.AppNetworkImage
import com.event.anime.comman.AppText
import com.event.anime.comman.AppTextSmallTitle
import com.event.anime.model.item.Anime
import com.event.anime.model.item.Image
import com.event.anime.model.item.Images
import com.event.anime.ui.theme.colorBlack
import com.event.anime.ui.theme.colorGrey
import com.event.anime.ui.theme.colorWhite

@Composable
fun AnimeItem(
    anime: Anime,
    onAnimeClick: (Int) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .border(
                width = 0.1.dp,
                color = colorBlack,
                shape = RoundedCornerShape(size = 8.dp),
            )
            .background(color = colorWhite)
            .heightIn(min = 250.dp)
            .clickable { onAnimeClick.invoke(anime.malId ?: 0) }
    ) {
        AppNetworkImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            model = anime.images?.jpg?.imageUrl.toString()
        )

        Column(modifier = Modifier.padding(12.dp)) {
            AppTextSmallTitle(
                maxLines = 2,
                text = anime.title.toString()
            )

            AppText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp),
                text = String.format("%s %s", stringResource(R.string.desc_episodes), anime.episodes)
            )

            AppText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp),
                maxLines = 1,
                text = String.format("%s %s", stringResource(R.string.desc_rating), anime.rating)
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun AnimeItemPreview() {
    AnimeItem(
        anime = Anime(
            images = Images(
                jpg = Image(
                    imageUrl = "https://cdn.myanimelist.net/images/anime/1015/138006.jpg"
                )
            ),
            title = "Naruto",
            episodes = 220,
            rating = "PG-13"
        )
    )
}