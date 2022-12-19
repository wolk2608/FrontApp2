package com.example.frontapp2.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun CircleButton(
    text: String,
    onClicked: () -> Unit,
    gradient: Brush,
    textColor: Color,
    image: ImageVector
) {

    val borderGrad = Brush.linearGradient(
        listOf(
            MaterialTheme.colors.onBackground,
            MaterialTheme.colors.onPrimary,
        )
    )
    val size = maxOf(
        LocalConfiguration.current.screenWidthDp.dp,
        LocalConfiguration.current.screenHeightDp.dp
    ) / 2

    Button(
        modifier = Modifier.size(size),
        onClick = { onClicked() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            modifier = Modifier
                .background(shape = CircleShape, brush = gradient)
                .fillMaxSize()
                .border(border = BorderStroke(3.dp, borderGrad), shape = CircleShape),  //
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(MaterialTheme.typography.h4.fontSize.value.dp),
                    imageVector = image,
                    contentDescription = "icon",
                    tint = textColor
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = text.uppercase(),
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    color = textColor
                )
            }
        }
    }
}