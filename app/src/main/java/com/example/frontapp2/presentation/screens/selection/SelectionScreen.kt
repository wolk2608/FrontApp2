package com.example.frontapp2.presentation.screens.selection

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.UploadFile
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.frontapp2.navigation.Screen
import com.example.frontapp2.presentation.components.CircleButton
import com.example.frontapp2.presentation.screens.main.SharedViewModel
import com.example.frontapp2.ui.theme.ButtonGradient
import org.koin.androidx.compose.getViewModel

@Composable
fun SelectionScreen(
    sharedViewModel: SharedViewModel,
    selectionViewModel: SelectionViewModel = getViewModel<SelectionViewModel>()
) {
    val photoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { sharedViewModel.setSharedImage(it) }

    LaunchedEffect(Unit) { sharedViewModel.changeScreenTitle(Screen.Selection.title) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircleButton(
            text = "Select image",
            onClicked = {
                photoPicker.launch(
                    PickVisualMediaRequest(
                        ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                )
            },
            gradient = ButtonGradient,
            textColor = Color.White,
            image = Icons.Outlined.UploadFile
        )
    }
}