package com.example.myapplicationw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationw.model.Model
import com.example.myapplicationw.model.Student
import java.io.Serializable

class EditStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val student: Student? = intent.getSerializableExtra("student") as Student?
        val position: Int? = intent.getSerializableExtra("position") as Int?

        val nameInput = findViewById<EditText>(R.id.edit_student_name_text_field)
        val idInput = findViewById<EditText>(R.id.edit_student_id_text_field)
        val phoneInput = findViewById<EditText>(R.id.edit_student_phone_text_field)
        val addressInput = findViewById<EditText>(R.id.edit_student_address_text_field)
        nameInput.setText(student?.name)
        idInput.setText(student?.id)
        phoneInput.setText(student?.phone)
        addressInput.setText(student?.address)

        val saveButton = findViewById<Button>(R.id.edit_student_save_button)
        saveButton.setOnClickListener {
            val editedStudent =
                Student(
                    name = nameInput.text.toString(),
                    id = idInput.text.toString(),
                    avatarUrl = "",
                    address = addressInput.text.toString(),
                    phone = phoneInput.text.toString(),
                    isChecked = student?.isChecked ?: false)
            Model.shared.editStudent(editedStudent, position!!)
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("student", editedStudent as Serializable)
            intent.putExtra("position", position as Serializable)
            startActivity(intent)
        }

        val deleteButton = findViewById<Button>(R.id.edit_student_delete_button)
        deleteButton.setOnClickListener {
            Model.shared.deleteStudent(student!!)
            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        val cancelButton = findViewById<Button>(R.id.edit_student_cancel_button)
        cancelButton.setOnClickListener {
            finish()
        }
    }
}