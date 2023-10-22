package com.example.destinationsapp.ui.screen

import androidx.compose.runtime.Composable
import com.example.destinationsapp.model.Destination
import com.example.destinationsapp.model.DestinationType

@Composable
fun SearchScreen(
    navigateToDetailScreen: (Destination) -> Unit,
    filter: (DestinationType?) -> Unit,
    state: DestinationUiState,
) {

}