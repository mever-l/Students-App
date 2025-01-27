package com.example.myapplicationw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.navigation.Navigation
import com.example.myapplicationw.model.Model
import com.example.myapplicationw.model.Student

class AddStudentFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_student, container, false)
        init(view)
        return view
    }

    fun init(view: View) {
        val saveButton = view.findViewById<Button>(R.id.add_student_save_button)
        saveButton.setOnClickListener {
            val name = view.findViewById<EditText>(R.id.add_student_name_text_field).text.toString()
            val id = view.findViewById<EditText>(R.id.add_student_id_text_field).text.toString()
            val address = view.findViewById<EditText>(R.id.add_student_address_text_field).text.toString()
            val phone = view.findViewById<EditText>(R.id.add_student_phone_text_field).text.toString()
            val checkBox = view.findViewById<CheckBox>(R.id.checkBox)
            val student =
                Student(
                    name = name,
                    id = id,
                    avatarUrl = "",
                    address = address,
                    phone = phone,
                    isChecked = checkBox.isChecked)
            Model.shared.addStudent(student)
            Navigation.findNavController(view).popBackStack()
        }

        val cancelButton = view.findViewById<Button>(R.id.add_student_cancel_button)
        cancelButton.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
    }

}