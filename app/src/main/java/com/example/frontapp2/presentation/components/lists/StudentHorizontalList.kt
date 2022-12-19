package com.example.frontapp2.presentation.components.lists

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.frontapp2.domain.models.Student
import com.example.frontapp2.presentation.components.list_items.StudentHorizontalItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StudentHorizontalList(students: List<Student>) {
    val list = remember { mutableStateListOf<Student>().apply { addAll(students) } }

    Column {
        Row(
            modifier = Modifier
                .padding(vertical = 14.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Students",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = list, key = { it.id }) { student ->
                Row(
                    Modifier
                        .animateItemPlacement(animationSpec = tween(600))
                        .fillMaxWidth()) {
                    StudentHorizontalItem(student = student) { list.remove(student) }
                }
            }
        }
    }
}