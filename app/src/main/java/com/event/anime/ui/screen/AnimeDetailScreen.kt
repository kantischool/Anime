package com.event.anime.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.event.anime.R
import com.event.anime.comman.AppNetworkImage
import com.event.anime.comman.AppScaffold
import com.event.anime.comman.AppText
import com.event.anime.comman.AppTextSmallTitle
import com.event.anime.comman.ShowAppSnackbar
import com.event.anime.model.item.AnimeData
import com.event.anime.shimmer.AnimeDetailShimmerScreen
import com.event.anime.state.AnimeDetailUiEvent
import com.event.anime.ui.item.VideoPlayer
import com.event.anime.viewmodel.AnimeDetailViewModel

@Composable
fun AnimeDetailScreen(
    onBack: () -> Unit,
    animId: () -> Int
) {

    val viewModel = hiltViewModel<AnimeDetailViewModel>()
    val viewState by viewModel.consumableState().collectAsState()

    val anime by remember { derivedStateOf { viewState.anime } }
    val isLoading by remember { derivedStateOf { viewState.isLoading } }
    val snackBarMessage by remember { derivedStateOf { viewState.snackBarMessage } }
    val snackBarHostState = remember { SnackbarHostState() }

    if (animId() != 0) {
        viewModel.onEvent(AnimeDetailUiEvent.GetAnimeDetail(animId()))
    }

    AnimeDetailScreenContent(
        anime = { anime },
        isLoading = { isLoading },
        onBack = onBack,
        snackBarHostState = snackBarHostState
    )

    ShowAppSnackbar(
        snackbarHostState = snackBarHostState,
        snackbarMessage = { snackBarMessage },
    )
}

@Composable
fun AnimeDetailScreenContent(
    anime: () -> AnimeData? = { null },
    isLoading: () -> Boolean = { true },
    onBack: () -> Unit = {},
    snackBarHostState: SnackbarHostState = remember { SnackbarHostState() },
) {
    AppScaffold(
        title = "Anime Detail",
        showNavigationIcon = true,
        navigationIconResId = R.drawable.ic_back,
        onNavigationIconClick = onBack,
        snackBarHostState = snackBarHostState,
    ) { contentPadding ->

        if (isLoading()) {
            AnimeDetailShimmerScreen(modifier = Modifier.padding(contentPadding))
        } else {
            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                anime()?.let {
                    Box {
                        if (it.anime?.trailer?.youtubeId?.isNotEmpty() == true) {
                            VideoPlayer(
                                it.anime.trailer.youtubeId.toString(),
                                LocalLifecycleOwner.current
                            )
                        } else {
                            AppNetworkImage(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(160.dp),
                                model = it.anime?.images?.jpg?.imageUrl.toString()
                            )
                        }
                    }

                    AppTextSmallTitle(
                        modifier = Modifier.padding(top = 12.dp),
                        maxLines = 2,
                        text = it.anime?.title.toString()
                    )

                    AppText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 6.dp),
                        text = it.anime?.synopsis.toString()
                    )

                    AppText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 6.dp),
                        fontSize = TextUnit(16f, TextUnitType.Sp),
                        fontWeight = FontWeight.SemiBold,
                        text = String.format(
                            "%s %s",
                            stringResource(R.string.decs_genres),
                            it.genres.toString()
                        )
                    )

                    AppText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 2.dp),
                        fontSize = TextUnit(16f, TextUnitType.Sp),
                        fontWeight = FontWeight.SemiBold,
                        text = String.format(
                            "%s %s",
                            stringResource(R.string.desc_episodes),
                            it.anime?.episodes
                        )
                    )

                    AppText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 2.dp),
                        fontSize = TextUnit(16f, TextUnitType.Sp),
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        text = String.format(
                            "%s %s",
                            stringResource(R.string.desc_rating),
                            it.anime?.rating
                        )
                    )

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                    )
                }
            }
        }

    }
}