package com.example.myapplicationw

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationw.model.Model
import com.example.myapplicationw.model.Student

class AddStudentActivity : AppCompatActivity() {
    var students: MutableList<Student>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        this.students = Model.shared.students
        val saveButton = findViewById<Button>(R.id.add_student_save_button)
        saveButton.setOnClickListener {
            val name = findViewById<EditText>(R.id.add_student_name_text_field).text.toString()
            val id = findViewById<EditText>(R.id.add_student_id_text_field).text.toString()
            val address = findViewById<EditText>(R.id.add_student_address_text_field).text.toString()
            val phone = findViewById<EditText>(R.id.add_student_phone_text_field).text.toString()

            val student =
                Student(
                    name = name,
                    id = id,
                    avatarUrl = "",
                    address = address,
                    phone = phone,
                    isChecked = false)
            Model.shared.addStudent(student)
            finish()

        }

        val cancelButton = findViewById<Button>(R.id.add_student_cancel_button)
        cancelButton.setOnClickListener {
            finish()
        }
    }
}