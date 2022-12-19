package com.example.frontapp2.presentation.screens.lazy_list

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frontapp2.domain.Repository
import com.example.frontapp2.domain.models.Student
import kotlinx.coroutines.launch

class LazyListViewModel(
    private val repository: Repository
) : ViewModel()  {

    private val _students = mutableStateListOf<Student>()
    val students get() = _students

    init {
        getStudents()
    }

    private fun getStudents() {
        viewModelScope.launch {
            _students.addAll(repository.getStudents())
        }
    }
}