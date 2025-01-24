package com.example.myapplicationw

import android.content.Intent
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
import java.io.Serializable

class EditStudentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_student, container, false)
        val student: Student?= null
//        val student: Student? = intent.getSerializableExtra("student") as Student?
//        val position: Int? = intent.getSerializableExtra("position") as Int?

        val nameInput = view.findViewById<EditText>(R.id.edit_student_name_text_field)
        val idInput = view.findViewById<EditText>(R.id.edit_student_id_text_field)
        val phoneInput = view.findViewById<EditText>(R.id.edit_student_phone_text_field)
        val addressInput = view.findViewById<EditText>(R.id.edit_student_address_text_field)
        val checkBoxInput = view.findViewById<CheckBox>(R.id.checkBox)

        nameInput.setText(student?.name)
        idInput.setText(student?.id)
        phoneInput.setText(student?.phone)
        addressInput.setText(student?.address)
        checkBoxInput.isChecked = student?.isChecked ?: false

        val saveButton = view.findViewById<Button>(R.id.edit_student_save_button)
        saveButton.setOnClickListener {
            student?.isChecked = checkBoxInput.isChecked
            val editedStudent =
                Student(
                    name = nameInput.text.toString(),
                    id = idInput.text.toString(),
                    avatarUrl = "",
                    address = addressInput.text.toString(),
                    phone = phoneInput.text.toString(),
                    isChecked = student?.isChecked ?: false)
//            Model.shared.editStudent(editedStudent, position!!)
//            val intent = Intent(this, StudentDetailsActivity::class.java)
//            intent.putExtra("student", editedStudent as Serializable)
//            intent.putExtra("position", position as Serializable)
//            startActivity(intent)
        }

        val deleteButton = view.findViewById<Button>(R.id.edit_student_delete_button)
        deleteButton.setOnClickListener {
            Model.shared.deleteStudent(student!!)
            Navigation.findNavController(view).navigate(R.id.action_editStudentFragment_to_studentsRecyclerViewFragment)
        }

        val cancelButton = view.findViewById<Button>(R.id.edit_student_cancel_button)
        cancelButton.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
        return view
    }

}