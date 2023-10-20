package com.fraporitmos.englishtenses.android.di


import com.fraporitmos.englishtenses.android.screens.HomeScreen.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
}