package com.fraporitmos.englishtenses.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fraporitmos.englishtenses.android.screens.ArScreen.ARScreen
import com.fraporitmos.englishtenses.android.screens.DetailScreen.DetailScreen
import com.fraporitmos.englishtenses.android.screens.HomeScreen.HomeScreen
import com.fraporitmos.englishtenses.android.screens.HomeScreen.viewModel.HomeViewModel
import com.fraporitmos.englishtenses.android.theme.MyApplicationTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val homeViewModel: HomeViewModel = koinViewModel()
                    val navController  = rememberNavController()
                    NavHost(navController = navController, startDestination =  "home_screen"){
                        composable("home_screen"){
                            HomeScreen(
                                navController = navController,
                                modifier = Modifier,
                                homeViewModel = homeViewModel
                            )
                        }
                        composable("detail_screen"){
                            DetailScreen(navController = navController, homeViewModel = homeViewModel)
                        }
                        composable("ar_screen/{model_url}", arguments =
                            listOf(navArgument("model_url") { type = NavType.StringType})
                        ){ backStackEntry ->
                            ARScreen(backStackEntry.arguments?.getString("model_url") ?: "")
                        }
                    }
                }
            }
        }
    }
}
