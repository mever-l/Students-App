package com.example.myapplicationw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationw.model.Model
import com.example.myapplicationw.model.Student
import java.io.Serializable

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val student: Student? = intent.getSerializableExtra("student") as Student?
        val position: Int? = intent.getSerializableExtra("position") as Int?
        val nameTextView: TextView = findViewById(R.id.textViewNameValue)
        val idTextView: TextView = findViewById(R.id.textViewIdValue)
        val addressTextView: TextView = findViewById(R.id.textViewAddressValue)
        val phoneTextView: TextView = findViewById(R.id.textViewPhoneValue)
        val checkBox: CheckBox = findViewById(R.id.checkBox)

        idTextView.text = student?.id
        nameTextView.text = student?.name
        addressTextView.text = student?.address
        phoneTextView.text = student?.phone
        checkBox.isChecked = student?.isChecked ?: false

        val editButton = findViewById<Button>(R.id.buttonEdit)
        editButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("student", student as Serializable)
            intent.putExtra("position", position as Serializable)
            startActivity(intent)
        }
        val backButton = findViewById<Button>(R.id.buttonBack)
        backButton.setOnClickListener {
            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            student?.isChecked = isChecked
            val editedStudent =
                Student(
                    name = student?.name ?: "",
                    id = student?.id ?: "" ,
                    avatarUrl = "",
                    address = student?.address ?: "",
                    phone = student?.phone ?: "",
                    isChecked = student?.isChecked ?: false)
            Model.shared.editStudent(editedStudent, position!!)
        }
    }
}