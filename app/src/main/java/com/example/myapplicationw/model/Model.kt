package com.example.myapplicationw.model
import android.util.Log
import com.example.myapplicationw.adapter.StudentsRecyclerAdapter

class Model private constructor() {
    val students: MutableList<Student> = ArrayList()
    val adapter = StudentsRecyclerAdapter(students)

    companion object {
        val shared = Model()
    }
    init {
        for (i in 0..6) {
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
     adapter.update(students)
        adapter.notifyItemInserted(students.size)
    }

    fun editStudent(student: Student) {
    }

    fun deleteStudent(student: Student) {
        students.remove(student)
        adapter.update(students)
        adapter.notifyItemInserted(students.size)
    }
}