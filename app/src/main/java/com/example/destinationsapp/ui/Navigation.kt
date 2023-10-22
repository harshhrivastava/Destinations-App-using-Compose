package com.example.destinationsapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.destinationsapp.ui.screen.DestinationViewModel
import com.example.destinationsapp.ui.screen.DetailScreen
import com.example.destinationsapp.ui.screen.HomeScreen
import com.example.destinationsapp.ui.screen.SearchScreen

enum class Screens {
    Home, Search, Detail
}

@Composable
fun Nav() {
    val navController = rememberNavController()
    val viewModel = DestinationViewModel()
    val state by viewModel.state.collectAsState()
    NavHost(
        navController = navController,
        startDestination = Screens.Home.name,
    ) {
        composable(Screens.Home.name) {
            HomeScreen(
                onNext = {
                    navController.navigate(Screens.Search.name)
                },
            )
        }
        composable(Screens.Search.name) {
            SearchScreen(
                state = state,
                navigateToDetailScreen = { destination ->
                    viewModel.setDestination(destination)
                    navController.navigate(Screens.Detail.name)
                },
                filter = { destinationType ->
                    viewModel.filter(destinationType)
                },
            )
        }
        composable(Screens.Detail.name) {
            DetailScreen(
                state = state,
            )
        }
    }
}