package com.fraporitmos.englishtenses.domain.usecases

import com.fraporitmos.englishtenses.domain.model.Pizza
import com.fraporitmos.englishtenses.domain.repository.QuestionRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetAllPizzas: KoinComponent {
    private val repository: QuestionRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(): List<Pizza>{
        return repository.getAllPizzas()
    }

}