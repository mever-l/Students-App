package com.example.myapplicationw.model

class Model private constructor() {
    val students: MutableList<Student> = ArrayList()
    companion object {
        val shared = Model()
    }
    init {
        for (i in 0..20) {
            val student = Student(
                name = "Ben Shapiro $i",
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