package com.fraporitmos.englishtenses.android.screens.HomeScreen.viewModel


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import com.fraporitmos.englishtenses.domain.model.Pizza
import com.fraporitmos.englishtenses.domain.usecases.GetAllPizzas
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeViewModel(
    val getAllPizzas: GetAllPizzas
) : ViewModel() {
    var pizzas by mutableStateOf<List<Pizza>>(listOf())
    var currentPizza = MutableLiveData<Pizza>()

    init {
        loadAllPizzas()
        getAllPizzas
    }

    fun setPizza(pizza: Pizza) {
        currentPizza.postValue(pizza)
    }

    fun loadAllPizzas() {
        viewModelScope.launch {

            try {
                val resultPizzas = getAllPizzas()
                pizzas = resultPizzas
            } catch (error: Throwable) {
                pizzas = listOf()
            }
        }
    }
}



