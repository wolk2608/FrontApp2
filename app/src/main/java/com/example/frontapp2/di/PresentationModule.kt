package com.example.frontapp2.di

import com.example.frontapp2.presentation.screens.image.ImageViewModel
import com.example.frontapp2.presentation.screens.lazy_list.LazyListViewModel
import com.example.frontapp2.presentation.screens.main.SharedViewModel
import com.example.frontapp2.presentation.screens.selection.SelectionViewModel
import com.example.frontapp2.presentation.screens.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentationModule = module {
    viewModel {
        SharedViewModel(get())
    }
    viewModel {
        SelectionViewModel(get())
    }
    viewModel {
        ImageViewModel(get(), get())
    }
    viewModel {
        LazyListViewModel(get())
    }
    viewModel {
        SplashViewModel(get())
    }
}