package com.fraporitmos.englishtenses.android.screens.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.fraporitmos.englishtenses.android.screens.HomeScreen.viewModel.HomeViewModel


@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier,
    homeViewModel: HomeViewModel = viewModel()
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(
                homeViewModel.pizzas,
                key = { _, pizza -> pizza.id }
            ) { _, pizza ->


                Cardpizza(pizza, modifier = Modifier.clickable {
                    homeViewModel.setPizza(pizza)
                    navController.navigate("detail_screen")
                })
            }
        }
    }


}

