package com.example.frontapp2.di

import android.content.ContentResolver
import com.example.frontapp2.data.RepositoryImpl
import com.example.frontapp2.domain.Repository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<Repository> {
        RepositoryImpl(get())
    }

    single<ContentResolver> { androidContext().contentResolver }
}