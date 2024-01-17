package com.tarikyasar.compose_destinations

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.tarikyasar.compose_destinations.model.Movie
import com.tarikyasar.compose_destinations.model.sampleMovieDate
import com.tarikyasar.compose_destinations.ui.theme.ComposedestinationsTheme

@Destination
@Composable
fun MovieDetailScreenRoute(
    movie: Movie
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(rememberScrollState())
    ) {
        if (movie.image != null) {
            Image(
                painter = painterResource(id = movie.image),
                contentDescription = "",
                modifier = Modifier.clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(24.dp))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = movie.title,
                    fontSize = 26.sp
                )

                Text(text = movie.director)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "",
                    tint = Color(0xFFFF9800)
                )

                Text(
                    text = movie.rating.toString(),
                    fontSize = 24.sp,
                    color = Color(0xFFFF9800)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = movie.description)
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailScreenPreview() {
    ComposedestinationsTheme {
        MovieDetailScreenRoute(movie = sampleMovieDate)
    }
}