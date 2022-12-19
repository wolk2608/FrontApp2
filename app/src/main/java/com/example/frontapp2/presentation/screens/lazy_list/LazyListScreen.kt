package com.example.frontapp2.presentation.screens.lazy_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.frontapp2.presentation.components.lists.StudentHorizontalList
import com.example.frontapp2.presentation.screens.main.SharedViewModel
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import com.example.frontapp2.navigation.Screen
import com.example.frontapp2.presentation.components.UpButton
import com.example.frontapp2.presentation.components.list_items.StudentVerticalItem
import com.example.frontapp2.presentation.screens.splash.HideUIVisibilityState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.koin.androidx.compose.getViewModel

@Composable
fun LazyListScreen (
    sharedViewModel: SharedViewModel,
    lazyListViewModel: LazyListViewModel = getViewModel<LazyListViewModel>()
) {
    HideUIVisibilityState(state = true)
    val systemUiController = rememberSystemUiController()
    val backgroundColor = MaterialTheme.colors.background
    LaunchedEffect(Unit) {
        sharedViewModel.changeScreenTitle(Screen.LazyList.title)
        systemUiController.setSystemBarsColor(backgroundColor)
    }

    val listState = rememberLazyGridState()
    LazyVerticalGrid(
        modifier = Modifier.padding(top = 14.dp, start = 14.dp, end = 14.dp),
        state = listState,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        single {
            Text(
                text = "Students",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
        singleList(items = lazyListViewModel.students) { student ->
            StudentVerticalItem(student = student)
        }
        single {
            StudentHorizontalList(students = lazyListViewModel.students)
        }
    }
    UpButton(state = listState)
}

private inline fun LazyGridScope.single(crossinline itemContent: @Composable (LazyGridItemScope.() -> Unit)) {
    item(
        span = { GridItemSpan(maxCurrentLineSpan) }
    ) {
        itemContent()
    }
}

private inline fun <T> LazyGridScope.singleList(items: List<T>, crossinline listContent: @Composable ((T) -> Unit)) {
    items(
        span = { GridItemSpan(maxCurrentLineSpan) },
        items = items
    ) { item ->
        listContent(item)
    }
}