package com.example.myapplicationw

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationw.model.Student

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
        val nameTextView: TextView = findViewById(R.id.textView5)
        val idTextView: TextView = findViewById(R.id.textView4)
        idTextView.text = student?.id
        nameTextView.text = student?.name

        val editButton = findViewById<Button>(R.id.buttonEdit)
        editButton.setOnClickListener {
            // Handle edit button click
        }
        val backButton = findViewById<Button>(R.id.buttonBack)
        backButton.setOnClickListener {
            finish()
        }
    }
}