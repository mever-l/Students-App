package com.example.myapplicationw.model

import android.util.Log

class Model private constructor() {
    val students: MutableList<Student> = ArrayList()
    companion object {
        val shared = Model()
    }
    init {
        for (i in 0..20) {
            val student = Student(
                name = "Hailey Kelly $i",
                id = i.toString(),
                avatarUrl = "",
                isChecked = false
            )
            students.add(student)
        }
    }

    fun addStudent(student: Student) {
     students.add(student)
    }

    fun editStudent(student: Student) {
    }

    fun deleteStudent(student: Student) {
        students.remove(student)
    }
}