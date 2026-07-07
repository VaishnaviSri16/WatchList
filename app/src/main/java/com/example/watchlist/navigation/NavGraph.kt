package com.example.watchlist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.watchlist.ui.theme.AddScreen
import com.example.watchlist.ui.theme.HomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onAddClick = { navController.navigate("add") })
        }
        composable("add") {
            AddScreen(onDone = { navController.popBackStack() })
        }
    }
}