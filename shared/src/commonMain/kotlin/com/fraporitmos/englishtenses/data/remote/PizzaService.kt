package com.fraporitmos.englishtenses.data.remote

import io.ktor.client.call.body
import io.ktor.client.request.get

internal class PizzaService: KtorApi() {
        suspend fun getPizzas(): List<PizzaRemote> = client.get {
            pathUrl("pizzas")
        }.body()
}