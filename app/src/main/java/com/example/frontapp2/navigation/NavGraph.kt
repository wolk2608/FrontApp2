package com.example.frontapp2.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.frontapp2.presentation.screens.image.ImageScreen
import com.example.frontapp2.presentation.screens.lazy_list.LazyListScreen
import com.example.frontapp2.presentation.screens.main.SharedViewModel
import com.example.frontapp2.presentation.screens.selection.SelectionScreen
import com.example.frontapp2.presentation.screens.splash.SplashScreen
import com.example.frontapp2.utils.Constants.INITIAL_OFFSET_X
import com.example.frontapp2.utils.Constants.SCREEN_TRANSIT_DURATION_MILLIS
import com.example.frontapp2.utils.Constants.TARGET_OFFSET_X
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(
            route = Screen.LazyList.route,
            enterTransition = { enterAnim() },
            exitTransition = { exitAnim() }
        ) {
            LazyListScreen(sharedViewModel = sharedViewModel)
        }
        composable(
            route = Screen.Splash.route,
            enterTransition = { fadeIn(animationSpec = tween(SCREEN_TRANSIT_DURATION_MILLIS * 2)) },
            exitTransition = { fadeOut(animationSpec = tween(SCREEN_TRANSIT_DURATION_MILLIS * 2)) },
        ) {
            SplashScreen(navController = navController)
        }
        composable(
            route = Screen.Selection.route,
            enterTransition = { if (navController.currentDestination!!.route!! != Screen.Splash.route) { fadeIn(animationSpec = tween(SCREEN_TRANSIT_DURATION_MILLIS)) } else { enterAnim() } } ,
            exitTransition = { exitAnim() },
        ) {
            SelectionScreen(sharedViewModel = sharedViewModel)
        }
        composable(
            route = Screen.Image.route,
            enterTransition = { enterAnim() },
            exitTransition = { exitAnim() },
        ) {
            ImageScreen(sharedViewModel = sharedViewModel)
        }
    }
}

fun enterAnim() = slideInHorizontally(animationSpec = tween(SCREEN_TRANSIT_DURATION_MILLIS), initialOffsetX = { INITIAL_OFFSET_X })
fun exitAnim() = slideOutHorizontally(animationSpec = tween(SCREEN_TRANSIT_DURATION_MILLIS), targetOffsetX = { TARGET_OFFSET_X })