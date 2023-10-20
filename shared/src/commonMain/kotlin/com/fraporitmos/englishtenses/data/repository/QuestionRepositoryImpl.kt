package com.fraporitmos.englishtenses.data.repository

import com.fraporitmos.englishtenses.data.remote.RemoteDataSource
import com.fraporitmos.englishtenses.data.util.toPizza
import com.fraporitmos.englishtenses.domain.model.Pizza
import com.fraporitmos.englishtenses.domain.repository.QuestionRepository


internal class QuestionRepositoryImpl(
    private val remoteDateSource: RemoteDataSource
): QuestionRepository {

    override suspend fun getAllPizzas(): List<Pizza> {

            return remoteDateSource.getSentences().map {
                it.toPizza()
        }
    }
}