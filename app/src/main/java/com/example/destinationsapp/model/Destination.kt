package com.example.destinationsapp.model

data class Destination(
    val name: String,
    val stars: Int,
    val location: String,
    val description: String,
    val totalPricePerPerson: Int,
    val totalNumberOfDays: Int,
    val withGuide: Boolean,
    val destinationType: DestinationType,
    val image: Int,
    val isFav: Boolean = false,
)

enum class DestinationType {
    Beach,
    Mountain,
    Hotel,
}