package com.fraporitmos.englishtenses.domain.repository

import com.fraporitmos.englishtenses.domain.model.Pizza

internal interface QuestionRepository {

    suspend fun getAllPizzas(): List<Pizza>

}