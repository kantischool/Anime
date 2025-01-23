package com.event.anime.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.event.anime.R
import com.event.anime.comman.AppScaffold
import com.event.anime.comman.ShowAppSnackbar
import com.event.anime.model.item.Anime
import com.event.anime.shimmer.AnimeShimmerScreen
import com.event.anime.ui.component.AnimeList
import com.event.anime.viewmodel.AnimeViewModel

@Composable
fun AnimeScreen(
    onNavigateToAnimeDetail: (Int) -> Unit
) {
    val viewModel = hiltViewModel<AnimeViewModel>()
    val viewState by viewModel.consumableState().collectAsState()

    val animeList by remember { derivedStateOf { viewState.animeList } }
    val isLoading by remember { derivedStateOf { viewState.isLoading } }
    val snackBarMessage by remember { derivedStateOf { viewState.snackBarMessage } }
    val snackBarHostState = remember { SnackbarHostState() }

    AnimeScreenContent(
        animeList = { animeList },
        isLoading = { isLoading },
        onAnimeClick = { animeId -> onNavigateToAnimeDetail.invoke(animeId) }
    )

    ShowAppSnackbar(
        snackbarHostState = snackBarHostState,
        snackbarMessage = { snackBarMessage },
    )
}

@Composable
fun AnimeScreenContent(
    animeList: () -> List<Anime> = { emptyList() },
    isLoading: () -> Boolean = { true },
    onAnimeClick: (Int) -> Unit = {},
    snackBarHostState: SnackbarHostState = remember { SnackbarHostState() },
) {
    AppScaffold(
        title = stringResource(R.string.desc_animes),
        showNavigationIcon = false,
        snackBarHostState = snackBarHostState
    ) { contentPadding ->

        if (isLoading()) {
            AnimeShimmerScreen(modifier = Modifier.padding(contentPadding))
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding)
                    .padding(horizontal = 16.dp)
            ) {
                AnimeList(
                    animeList = animeList,
                    onAnimeClick = onAnimeClick
                )
            }
        }
    }
}