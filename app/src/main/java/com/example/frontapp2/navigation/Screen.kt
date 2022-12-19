package com.example.frontapp2.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Animation
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.List

sealed class Screen (
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object LazyList: Screen(
        route = "lazyList",
        title = "LazyList",
        icon = Icons.Outlined.List
    )

    object Selection: Screen(
        route = "selection",
        title = "Selection",
        icon = Icons.Outlined.Circle
    )

    object Image: Screen(
        route = "image",
        title = "Image",
        icon = Icons.Outlined.Image
    )

    object Splash: Screen(
        route = "splash",
        title = "Splash",
        icon = Icons.Outlined.Animation
    )
}