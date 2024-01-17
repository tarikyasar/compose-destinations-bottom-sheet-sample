package com.tarikyasar.compose_destinations.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tarikyasar.compose_destinations.model.Movie
import com.tarikyasar.compose_destinations.model.sampleMovieData
import com.tarikyasar.compose_destinations.ui.theme.ComposedestinationsTheme

@Composable
fun MovieListItem(
    movie: Movie,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFD8D8D8),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 12.dp, vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(text = movie.title, fontSize = 24.sp)
        
        Spacer(modifier = Modifier.weight(1f))

        Text(text = movie.rating.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun MovieListItemPreview() {
    ComposedestinationsTheme {
        MovieListItem(movie = sampleMovieData)
    }
}