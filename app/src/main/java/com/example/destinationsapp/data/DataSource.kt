package com.example.destinationsapp.data

import com.example.destinationsapp.model.Destination

class DestinationData {
    fun getData(
        query: String? = null,
    ) : List<Destination> {
        return if(query != null) {
            destinationsList.filter {
                it.destinationType.name == query
            }.sortedBy {
                it.isFav
            }
        } else {
            destinationsList
        }
    }
}