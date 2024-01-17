package com.tarikyasar.compose_destinations.model

import com.tarikyasar.compose_destinations.R
import java.io.Serializable

data class Movie(
    val title: String,
    val rating: Double,
    val director: String,
    val description: String,
    val image: Int? = null
) : Serializable

val sampleMovieData = Movie(
    title = "Midsommar",
    rating = 7.1,
    director = "Ari Aster",
    description = "A couple travels to Northern Europe to visit a rural hometown's fabled Swedish mid-summer festival. What begins as an idyllic retreat quickly devolves into an increasingly violent and bizarre competition at the hands of a pagan cult.",
    image = R.drawable.midsommar
)