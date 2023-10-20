package com.fraporitmos.englishtenses.di

import com.fraporitmos.englishtenses.common.provideDispatcher
import com.fraporitmos.englishtenses.data.remote.PizzaService
import com.fraporitmos.englishtenses.data.remote.RemoteDataSource
import com.fraporitmos.englishtenses.data.repository.QuestionRepositoryImpl
import com.fraporitmos.englishtenses.domain.repository.QuestionRepository
import com.fraporitmos.englishtenses.domain.usecases.GetAllPizzas
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { PizzaService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<QuestionRepository> { QuestionRepositoryImpl(get()) }
    factory { GetAllPizzas() }

}

private val sharedModules = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModules


