package com.example.destinationsapp.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.destinationsapp.data.DestinationData
import com.example.destinationsapp.model.Destination
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

    fun clickedLike() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    selectedDestination = it.selectedDestination?.copy(
                        isFav = it.selectedDestination.isFav.not()
                    )
                )
            }
        }
    }

    fun filter(
        query: String?,
    ): List<Destination> {
        return destinationData.getData(query)
    }
}