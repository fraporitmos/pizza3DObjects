package com.fraporitmos.englishtenses.data.remote

import com.fraporitmos.englishtenses.common.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource(
    private val apiService: PizzaService,
    private val dispatcher: Dispatcher
) {

    suspend fun getSentences() = withContext(dispatcher.io){
        apiService.getPizzas()
    }

}