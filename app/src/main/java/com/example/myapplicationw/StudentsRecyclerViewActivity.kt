package com.example.myapplicationw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationw.adapter.StudentsRecyclerAdapter
import com.example.myapplicationw.model.Model
import com.example.myapplicationw.model.Student
import java.io.Serializable

interface OnItemClickListener {
    fun onItemClick(student: Student?, position: Int)
}

class StudentsRecyclerViewActivity : AppCompatActivity() {
    var students: MutableList<Student>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val addStudentButton: Button = findViewById(R.id.recycler_activity_add_student_button)
        addStudentButton.setOnClickListener {

            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }
        students = Model.shared.students

        val recyclerView: RecyclerView = findViewById(R.id.students_recycler_view)
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = StudentsRecyclerAdapter(students)
        adapter.listener = object : OnItemClickListener {
            override fun onItemClick(student: Student?, position: Int) {
                val intent = Intent(this@StudentsRecyclerViewActivity, StudentDetailsActivity::class.java)
                intent.putExtra("student", student as Serializable)
                intent.putExtra("position", position as Serializable)
                startActivity(intent)
            }
        }
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        (findViewById<RecyclerView>(R.id.students_recycler_view).adapter as? StudentsRecyclerAdapter)?.notifyDataSetChanged()
    }
}