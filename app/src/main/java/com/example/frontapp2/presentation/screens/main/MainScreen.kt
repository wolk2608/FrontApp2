package com.example.frontapp2.presentation.screens.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.frontapp2.navigation.Screen
import com.example.frontapp2.navigation.SetupNavGraph
import com.example.frontapp2.presentation.components.BottomNav
import com.example.frontapp2.presentation.components.TopBarMain
import com.example.frontapp2.utils.Constants

@ExperimentalAnimationApi
@Composable
fun MainScreen(
    sharedViewModel: SharedViewModel,
    navController: NavHostController
) {

    var title by remember { mutableStateOf("") }
    val popBackStack: () -> Unit = { navController.popBackStack() }
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    var showTopBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect{ backStackEntry ->
            title = when (backStackEntry.destination.route) {
                Screen.LazyList.route -> Screen.LazyList.title
                Screen.Selection.route -> Screen.Selection.title
                Screen.Image.route -> Screen.Image.title
                else -> ""
            }
        }
    }

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        Screen.Splash.route -> false
        else -> true
    }
    showTopBar = when (navBackStackEntry?.destination?.route) {
        Screen.Splash.route -> false
        else -> true
    }

    Scaffold(
        topBar = {
            if (showTopBar) TopBarMain(
                isDarkTheme = sharedViewModel.isDarkThemeState,
                title = sharedViewModel.title,
                onClickNavIcon =
                if (navController.currentDestination?.route != Screen.LazyList.route) popBackStack
                else Constants.EMPTY_LAMBDA
            ) {
                sharedViewModel.changeThemeState()
            }
        },
        bottomBar = { if (showBottomBar) BottomNav(navController = navController) },
        content = {
            Box(modifier = Modifier.padding(it)) {
                SetupNavGraph(navController = navController, sharedViewModel = sharedViewModel)
            }
        }
    )
}