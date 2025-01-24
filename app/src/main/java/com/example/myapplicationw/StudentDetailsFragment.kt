package com.example.myapplicationw

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import com.example.myapplicationw.model.Model
import com.example.myapplicationw.model.Student
import java.io.Serializable

class StudentDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val student: Student?=null
        val view = inflater.inflate(R.layout.fragment_student_details, container, false)
//        val student: Student? = intent.getSerializableExtra("student") as Student?
//        val position: Int? = intent.getSerializableExtra("position") as Int?
        val idTextView: TextView = view.findViewById(R.id.textViewIdValue)
        val nameTextView: TextView = view.findViewById(R.id.textViewNameValue)
        val addressTextView: TextView = view.findViewById(R.id.textViewAddressValue)
        val phoneTextView: TextView = view.findViewById(R.id.textViewPhoneValue)
        val checkBox: CheckBox = view.findViewById(R.id.checkBox)

        idTextView.text = student?.id
        nameTextView.text = student?.name
        addressTextView.text = student?.address
        phoneTextView.text = student?.phone
        checkBox.isChecked = student?.isChecked ?: false

        val editButton = view.findViewById<Button>(R.id.buttonEdit)
        editButton.setOnClickListener {
//            val intent = Intent(this, EditStudentActivity::class.java)
//            intent.putExtra("student", student as Serializable)
//            intent.putExtra("position", position as Serializable)
//            startActivity(intent)
        }
        val backButton = view.findViewById<Button>(R.id.buttonBack)
        backButton.setOnClickListener {
//            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
//            startActivity(intent)
        }

        checkBox.setOnCheckedChangeListener { _, isChecked ->
//            student?.isChecked = isChecked
//            val editedStudent =
//                Student(
//                    name = student?.name ?: "",
//                    id = student?.id ?: "" ,
//                    avatarUrl = "",
//                    address = student?.address ?: "",
//                    phone = student?.phone ?: "",
//                    isChecked = student?.isChecked ?: false)
//            Model.shared.editStudent(editedStudent, position!!)
        }

        return view
    }
}