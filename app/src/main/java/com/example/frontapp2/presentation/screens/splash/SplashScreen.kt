package com.example.frontapp2.presentation.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.frontapp2.R
import com.example.frontapp2.navigation.Screen
import com.example.frontapp2.ui.theme.MainGradient
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    var startAnimation by remember { mutableStateOf(false) }
    HideUIVisibilityState(state = false)
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )
    val degrees = remember { Animatable(0f) }

    LaunchedEffect(true) {
        startAnimation = true
        degrees.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 2000,
                delayMillis = 500
            )
        )
        startAnimation = false
        delay(1000)
        navController.popBackStack()
        navController.navigate(Screen.LazyList.route)
    }
    Splash(alpha = alphaAnim, degrees = degrees.value)
}

@Composable
fun Splash(alpha: Float, degrees: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = MainGradient)
            .alpha(alpha = alpha),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(256.dp).rotate(degrees = degrees),
            painter = painterResource(id = R.drawable.ic_kit_loading),
            contentDescription = "Splash Icon"
        )
    }
}

@Composable
fun HideUIVisibilityState(state: Boolean) {
    val systemUiController = rememberSystemUiController()
    systemUiController.isSystemBarsVisible = state
    systemUiController.isNavigationBarVisible = state
    systemUiController.isStatusBarVisible = state
    systemUiController.isNavigationBarContrastEnforced = state
}