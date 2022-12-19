package com.example.frontapp2.presentation.screens.image

import android.provider.MediaStore
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.frontapp2.R
import com.example.frontapp2.navigation.Screen
import com.example.frontapp2.presentation.screens.main.SharedViewModel
import com.example.frontapp2.utils.PaletteGenerator.extractColorsFromBitmap
import org.koin.androidx.compose.getViewModel

@Composable
fun ImageScreen (
    sharedViewModel: SharedViewModel,
    imageViewModel: ImageViewModel = getViewModel<ImageViewModel>()
) {
    if (sharedViewModel.sharedImage != null) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        sharedViewModel.changeScreenTitle(Screen.Image.title)
        /*val source = ImageDecoder.createSource(context.contentResolver, sharedViewModel.sharedImage!!)
        val bitmap = ImageDecoder.decodeBitmap(source)*/

        val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, sharedViewModel.sharedImage)
        if (bitmap != null) {
            imageViewModel.setColorPalette(
                colors = extractColorsFromBitmap(
                    bitmap = bitmap
                )
            )
        }
    }
        val colorPalette by imageViewModel.colorPalette

        if (colorPalette.isNotEmpty()) {
    val vibrant by remember { mutableStateOf(colorPalette["vibrant"]!!) }
    val darkMuted by remember { mutableStateOf(colorPalette["darkMuted"]!!) }
    val onDarkVibrant by remember { mutableStateOf(colorPalette["onDarkVibrant"]!!) }

    //val systemUiController = rememberSystemUiController()
    //systemUiController.setNavigationBarColor(Color(android.graphics.Color.parseColor(darkVibrant)))
    //systemUiController.setStatusBarColor(Color(android.graphics.Color.parseColor(vibrant)))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(
                listOf(
                    Color(android.graphics.Color.parseColor(vibrant)),
                    Color(android.graphics.Color.parseColor(darkMuted))
                )
            )
            ),
        contentAlignment = Alignment.Center,
    ) {
        AsyncImage(
            modifier = Modifier.size(300.dp).clip(RoundedCornerShape(size = 20.dp)),
            //model = ImageRequest.Builder(LocalContext.current)
            model = ImageRequest.Builder(context)
                .placeholder(R.drawable.ic_kit)
                .data(sharedViewModel.sharedImage)
                .crossfade(enable = true)
                .build(),
            contentDescription = "Picked Image",
            contentScale = ContentScale.Crop,
        )
    }
}
    } else {

    }
}