package com.example.frontapp2.presentation.screens.image

import android.content.ContentResolver
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.frontapp2.domain.Repository

class ImageViewModel(
    private val repository: Repository,
    private val contentResolver: ContentResolver
    ) : ViewModel()  {

    private val _colorPalette: MutableState<Map<String, String>> = mutableStateOf(mapOf())
    val colorPalette: State<Map<String, String>> = _colorPalette

    fun setColorPalette(colors: Map<String, String>) {
        _colorPalette.value = colors
    }

    fun uriToBitmap(uri: Uri): Bitmap {
        val source = ImageDecoder.createSource(contentResolver,uri)
        return ImageDecoder.decodeBitmap(source)
    }
}