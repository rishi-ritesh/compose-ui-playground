package com.rishiritesh.composeplayground.playground.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.rishiritesh.composeplayground.playground.CatalogScreen
import com.rishiritesh.composeplayground.playground.demos.animations.animatedbutton.AnimatedButtonScreen
import com.rishiritesh.composeplayground.playground.demos.animations.animation_basics.AnimationBasicsScreen
import com.rishiritesh.composeplayground.playground.demos.layouts.complexlazy.ComplexLazyScreen
import com.rishiritesh.composeplayground.playground.ui.DemoTopBar

@Composable
fun PlaygroundNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = PlaygroundScreen.Catalog.route
) {
    NavHost(navController = navController, startDestination = startDestination) {

        composable(PlaygroundScreen.Catalog.route) {
            CatalogScreen(onOpenDemo = { screen ->
                when (screen) {
                    PlaygroundScreen.AnimatedButton ->
                        navController.navigate(PlaygroundScreen.AnimatedButton.route)
                    PlaygroundScreen.ComplexLazy ->
                        navController.navigate(PlaygroundScreen.ComplexLazy.route)
                    PlaygroundScreen.AnimationBasics ->
                        navController.navigate(PlaygroundScreen.AnimationBasics.route)
                    else -> {}
                }
            })
        }

        composable(PlaygroundScreen.AnimatedButton.route) {
            Scaffold(
                topBar = {
                    DemoTopBar(title = PlaygroundScreen.AnimatedButton.title) {
                        navController.navigateUp()
                    }
                }
            ) { innerPadding ->
                AnimatedButtonScreen(modifier = Modifier.padding(innerPadding))
            }
        }

        composable(PlaygroundScreen.ComplexLazy.route) {
            Scaffold(
                topBar = {
                    DemoTopBar(title = PlaygroundScreen.ComplexLazy.title) {
                        navController.navigateUp()
                    }
                }
            ) { innerPadding ->
                ComplexLazyScreen(modifier = Modifier.padding(innerPadding))
            }
        }

        composable(PlaygroundScreen.AnimationBasics.route) {
            Scaffold(
                topBar = {
                    DemoTopBar(title = PlaygroundScreen.AnimationBasics.title) {
                        navController.navigateUp()
                    }
                }
            ) { innerPadding ->
                AnimationBasicsScreen(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}
