package com.example.myapplicationw

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationw.model.Model
import com.example.myapplicationw.model.Student

class RecyclerListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.recycler_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        students = Model.shared.students
//
//        val recyclerView: RecyclerView = findViewById(R.id.students_recycler_view)
//        recyclerView.setHasFixedSize(true)
//
//        val layoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = layoutManager
//
//        val adapter = StudentsRecyclerAdapter(students)
//        adapter.listener = object : OnItemClickListener {
//            override fun onItemClick(position: Int) {
//                Log.d("TAG", "On click Activity listener on position $position")
//            }
//


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val data = Model.instance.getAllStudents()
        val adapter = MyAdapter(data)
        recyclerView.adapter = adapter
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var title: TextView? = null
    var subTitle: TextView? = null
    var imageView: ImageView? = null

    fun bind(student: Student){}

    init {
        title = itemView.findViewById<TextView>(R.id.title)
        subTitle = itemView.findViewById<TextView>(R.id.subTitle)
        imageView = itemView.findViewById<TextView>(R.id.imageView)

        itemView.setOnClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                adapter.onClick(position)
            }
        }
    }
}

class MyAdapter(private val data: List<Student>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false)
        return MyViewHolder(itemView, this)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student = data[position]
        holder.title?.text = student.name
        holder.subTitle?.text = student.id.toString()
//        holder.imageView?.setImageResource(student.image)
    }

    override fun getItemCount(): Int {
        return data.size
    }
        private var listener: OnItemClickListener? = null

        fun setOnItemClickListener(listener: OnItemClickListener) {
            this.listener=listener
        }

    fun onClick(position: Int) {
        listener?.onItemClick(data[position])
    }

    interface OnItemClickListener {
        fun onItemClick(student: Student) {}
    }
}