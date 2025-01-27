package com.example.myapplicationw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.myapplicationw.model.Student

class StudentDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val view = inflater.inflate(R.layout.fragment_student_details, container, false)
        val student = arguments?.getSerializable("student") as? Student
        val position = arguments?.getInt("position") as Int

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
            val bundle = Bundle().apply {
                putSerializable("student", student)
                putInt("position", position )
            }
            findNavController().navigate(R.id.action_studentDetailsFragment_to_editStudentFragment, bundle)
        }
        val backButton = view.findViewById<Button>(R.id.buttonBack)
        backButton.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
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

//    override fun onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_fragment2, menu);  // Inflate a different menu for this fragment
//    }
}