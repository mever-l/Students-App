package com.example.myapplicationw.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationw.OnItemClickListener
import com.example.myapplicationw.R
import com.example.myapplicationw.model.Student

class StudentsRecyclerAdapter(private var students: List<Student>?): RecyclerView.Adapter<StudentViewHolder>() {

    var listener: OnItemClickListener? = null

    fun update(students: List<Student>?) {
        this.students = students
    }

    override fun getItemCount(): Int = students?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.student_list_row,
            parent,
            false
        )
        return StudentViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(
            student = students?.get(position),
            position = position
        )
    }
}