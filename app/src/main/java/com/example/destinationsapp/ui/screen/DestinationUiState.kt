package com.example.destinationsapp.ui.screen

import com.example.destinationsapp.data.destinationsList
import com.example.destinationsapp.model.Destination
import com.example.destinationsapp.model.DestinationType

data class DestinationUiState(
    val destinationList: List<Destination> = destinationsList,
    val selectedDestination: Destination? = null,
    val selectedType: DestinationType? = null,
)