package com.example.frontapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.example.frontapp2.presentation.screens.image.ImageViewModel
import com.example.frontapp2.presentation.screens.main.MainScreen
import com.example.frontapp2.presentation.screens.main.SharedViewModel
import com.example.frontapp2.ui.theme.FrontApp2Theme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.koin.androidx.viewmodel.ext.android.getViewModel

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val sharedViewModel = getViewModel<SharedViewModel>()
            FrontApp2Theme(darkTheme = sharedViewModel.isDarkThemeState) {
                //FrontApp2Theme() {
                val navController = rememberAnimatedNavController()
                MainScreen(
                    navController = navController,
                    sharedViewModel = sharedViewModel
                )
            }
        }
    }
}