package com.example.destinationsapp.data

import com.example.destinationsapp.model.Destination
import com.example.destinationsapp.model.DestinationType

class DestinationData {
    fun getData(
        query: DestinationType? = null,
    ) : List<Destination> {
        return if(query != null) {
            destinationsList.filter {
                it.destinationType == query
            }
        } else {
            destinationsList
        }
    }
}