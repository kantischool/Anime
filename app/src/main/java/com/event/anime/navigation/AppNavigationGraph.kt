package com.event.anime.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.event.anime.navigation.AppNavArgument.ANIME_ID
import com.event.anime.ui.screen.AnimeDetailScreen
import com.event.anime.ui.screen.AnimeScreen
import com.event.anime.util.fadeInTransition
import com.event.anime.util.fadeOutTransition
import com.event.anime.util.slideInHorizontallyTransition
import com.event.anime.util.slideOutHorizontallyTransition

const val NAVIGATION_HOST_ROUTE = "navigation_host_route"

@Composable
fun AppNavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.AnimeScreen.route,
        route = NAVIGATION_HOST_ROUTE,
        enterTransition = { slideInHorizontallyTransition },
        exitTransition = { fadeOutTransition },
        popEnterTransition = { fadeInTransition },
        popExitTransition = { slideOutHorizontallyTransition },
    ){
        composable(route = Screen.AnimeScreen.route) {
            AnimeScreen(
                onNavigateToAnimeDetail = {animeId ->
                    navController.navigateToAnimeDetailDetail(animeId)
                }
            )
        }

        composable(
            route = Screen.AnimeDetailScreen.buildOptionalArgsRoute(ANIME_ID),
            arguments = listOf(navArgument(ANIME_ID) { type = NavType.IntType })
        ) {backStackEntry ->
            val animId = backStackEntry.arguments?.getInt(ANIME_ID)
            AnimeDetailScreen(
                animId = { animId ?: 0 },
                onBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}
