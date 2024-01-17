package com.tarikyasar.compose_destinations

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.result.NavResult
import com.ramcosta.composedestinations.result.ResultRecipient
import com.tarikyasar.compose_destinations.destinations.AddMovieBottomSheetDestination
import com.tarikyasar.compose_destinations.destinations.MovieDetailScreenRouteDestination
import com.tarikyasar.compose_destinations.model.Movie
import com.tarikyasar.compose_destinations.model.sampleMovieData
import com.tarikyasar.compose_destinations.ui.composables.MovieListItem

@RootNavGraph(start = true)
@Destination
@Composable
fun MovieListScreenRoute(
    navigator: DestinationsNavigator,
    resultRecipient: ResultRecipient<AddMovieBottomSheetDestination, Movie>
) {
    val movies = remember { mutableStateListOf(sampleMovieData) }

    resultRecipient.onNavResult { result ->
        when (result) {
            is NavResult.Canceled -> Unit

            is NavResult.Value -> {
                movies.add(result.value)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            movies.forEach { movie ->
                MovieListItem(
                    movie = movie,
                    modifier = Modifier
                        .padding(vertical = 6.dp, horizontal = 12.dp)
                        .clickable {
                            navigator.navigate(MovieDetailScreenRouteDestination(movie))
                        }
                )
            }
        }

        FloatingActionButton(
            onClick = { navigator.navigate(AddMovieBottomSheetDestination) },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
        }
    }
}