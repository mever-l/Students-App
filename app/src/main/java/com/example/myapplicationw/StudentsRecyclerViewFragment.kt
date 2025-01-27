package com.example.myapplicationw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationw.adapter.StudentsRecyclerAdapter
import com.example.myapplicationw.model.Model
import com.example.myapplicationw.model.Student


interface OnItemClickListener {
    fun onItemClick(student: Student?, position: Int)
}

class StudentsRecyclerViewFragment : Fragment() {
    var students: MutableList<Student>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_students_recycler_view, container, false)
        val addStudentButton: Button = view.findViewById(R.id.recycler_activity_add_student_button)
        addStudentButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_studentsRecyclerViewFragment_to_addStudentFragment)
        }
        students = Model.shared.students

        val recyclerView: RecyclerView = view.findViewById(R.id.students_recycler_view)
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this@StudentsRecyclerViewFragment.context)
        recyclerView.layoutManager = layoutManager

        val adapter = StudentsRecyclerAdapter(students)
        adapter.listener = object : OnItemClickListener {
            override fun onItemClick(student: Student?, position: Int) {
                val bundle = Bundle().apply {
                    putSerializable("student", student)
                    putInt("position", position )
                }
                Navigation.findNavController(view).navigate(R.id.action_studentsRecyclerViewFragment_to_studentDetailsFragment, bundle)
            }
        }
        recyclerView.adapter = adapter
        return view
    }

}