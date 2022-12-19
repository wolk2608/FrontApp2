package com.example.frontapp2.domain

import com.example.frontapp2.domain.models.Student

interface Repository {

    fun addStudent(firstName: String, secondName: String, groupNum: String): Boolean

    fun addStudent(firstName: String, secondName: String, groupNum: String, photo: String): Boolean

    fun deleteStudent(id: Int): Boolean

    fun getStudent(id: Int): Student

    fun getStudents(): List<Student>

    fun setImage(url: String): Boolean

    fun getImage(): String
}