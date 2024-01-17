package com.tarikyasar.compose_destinations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.result.ResultBackNavigator
import com.ramcosta.composedestinations.spec.DestinationStyleBottomSheet
import com.tarikyasar.compose_destinations.model.Movie
import com.tarikyasar.compose_destinations.ui.theme.ComposedestinationsTheme

@Destination(style = DestinationStyleBottomSheet::class)
@Composable
fun AddMovieBottomSheet(
    resultNavigator: ResultBackNavigator<Movie>
) {
    AddMovieBottomSheetContent(
        onAddMovieClick = { movie ->
            resultNavigator.navigateBack(movie)
        }
    )
}

@Composable
fun AddMovieBottomSheetContent(
    onAddMovieClick: (Movie) -> Unit,
    modifier: Modifier = Modifier
) {
    var title by remember { mutableStateOf("") }
    var director by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = title,
            onValueChange = {
                title = it
            },
            label = {
                Text(text = "Title")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = director,
            onValueChange = {
                director = it
            },
            label = {
                Text(text = "Director")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = rating,
            onValueChange = {
                rating = it
            },
            label = {
                Text(text = "Rating")
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Decimal)
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = description,
            onValueChange = {
                description = it
            },
            label = {
                Text(text = "Description")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            onAddMovieClick(
                Movie(
                    title = title,
                    director = director,
                    rating = rating.toDouble(),
                    description = description
                )
            )
        }) {
            Text(text = "Add Movie")
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun AddMovieBottomSheetPreview() {
    ComposedestinationsTheme {
        AddMovieBottomSheetContent(
            onAddMovieClick = {

            }
        )
    }
}