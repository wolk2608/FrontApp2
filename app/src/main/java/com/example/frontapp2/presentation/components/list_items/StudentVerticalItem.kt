package com.example.frontapp2.presentation.components.list_items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.frontapp2.domain.models.Student
import com.example.frontapp2.presentation.components.AnimatedShimmer

@Composable
fun StudentVerticalItem(student: Student) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        val painter = rememberAsyncImagePainter(student.photo)
        Image(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(size = 8.dp)),
            painter = painter,
            contentScale = ContentScale.Crop,
            contentDescription = "Student photo"
        )
        if (painter.state !is AsyncImagePainter.State.Success) {
            AnimatedShimmer { ShimmerStudentVerticalItem(brush = it) }
        } else {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
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
    }
}

@Composable
fun ShimmerStudentVerticalItem(brush: Brush) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(
            modifier = Modifier
                .clip(RoundedCornerShape(size = 10.dp))
                .size(64.dp)
                .background(brush)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Spacer(modifier = Modifier.padding(2.dp))
            Spacer(
                modifier = Modifier
                    .height(15.dp)
                    .clip(RoundedCornerShape(size = 10.dp))
                    .fillMaxWidth()
                    .background(brush)
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Spacer(
                modifier = Modifier
                    .height(15.dp)
                    .clip(RoundedCornerShape(size = 10.dp))
                    .fillMaxWidth()
                    .background(brush)
            )
        }
    }
}

@Preview
@Composable
fun StudentVerticalItemPreview() {
    StudentVerticalItem(
        student = Student(
            id = 0,
            firstName = "FiestName",
            secondName = "SecondName",
            groupNum = "1234",
            photo = ""
        )
    )
}