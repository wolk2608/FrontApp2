package com.example.frontapp2.presentation.components.list_items

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.frontapp2.domain.models.Student

@Composable
fun StudentHorizontalItem(student: Student, onClick: () -> Unit) {
    val maxWidth = LocalConfiguration.current.screenWidthDp
    val itemWidth = (maxWidth.dp - 50.dp) / 2
    Column(
        modifier = Modifier
            .width(itemWidth)
            .clickable { onClick() },
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .width(64.dp)
                .height(64.dp)
                .clip(RoundedCornerShape(size = 8.dp)),
            painter = rememberAsyncImagePainter(student.photo),
            contentScale = ContentScale.Crop,
            contentDescription = "Student photo"
        )
        Text(
            text = student.firstName + " " + student.secondName,
            fontSize = MaterialTheme.typography.body1.fontSize,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Text(
            text = "Group " + student.groupNum,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun StudentHorizontalItemPreview() {
    StudentHorizontalItem(
        student = Student(
            id = 0,
            firstName = "FiestName",
            secondName = "SecondName",
            groupNum = "1234",
            photo = ""
        ), {}
    )
}