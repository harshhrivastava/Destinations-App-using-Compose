package com.example.destinationsapp.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.destinationsapp.data.DestinationData
import com.example.destinationsapp.model.Destination
import com.example.destinationsapp.model.DestinationType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DestinationViewModel : ViewModel() {
    private var _state = MutableStateFlow(DestinationUiState())
    val state: StateFlow<DestinationUiState> = _state.asStateFlow()
    private val destinationData: DestinationData = DestinationData()

//    fun search(
//       query: String,
//    ) {
//          TODO: Add Search Functionality
//    }

    fun setDestination(
        destination: Destination
    ) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    selectedDestination = destination
                )
            }
        }
    }

    fun filter(
        query: DestinationType?,
    ): List<Destination> {
        return destinationData.getData(query)
    }
}