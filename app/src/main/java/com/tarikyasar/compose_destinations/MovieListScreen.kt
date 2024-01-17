package com.tarikyasar.compose_destinations

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.tarikyasar.compose_destinations.destinations.MovieDetailScreenRouteDestination
import com.tarikyasar.compose_destinations.model.sampleMovieDate
import com.tarikyasar.compose_destinations.ui.composables.MovieListItem

@RootNavGraph(start = true)
@Destination
@Composable
fun MovieListScreenRoute(
    navigator: DestinationsNavigator
) {
    val movies = mutableListOf(
        sampleMovieDate
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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
}