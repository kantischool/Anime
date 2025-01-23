package com.event.anime.navigation

import androidx.navigation.NavController
import com.event.anime.navigation.AppNavArgument.ANIME_ID

fun NavController.navigateToAnimeDetailDetail(animeId: Int) {
    val hashMap: HashMap<String, Any?> = hashMapOf(
        ANIME_ID to animeId
    )
    navigate(Screen.AnimeDetailScreen.withOptionalArgs(hashMap))
}
