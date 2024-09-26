package com.example.todomaster

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import android.widget.ArrayAdapter

class TaskAdapter(context: Context, private val tasks: List<Task>) :
    ArrayAdapter<Task>(context, 0, tasks) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val task = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.task_item, parent, false)

        // Find views in the custom layout
        val taskTitle = view.findViewById<TextView>(R.id.taskitle)
        val taskDescription = view.findViewById<TextView>(R.id.taskDescription)
        val taskDateTime = view.findViewById<TextView>(R.id.taskdateTime)

        // Set the values from the Task object
        taskTitle.text = task?.title
        taskDescription.text = task?.description
        taskDateTime.text = "${task?.date} at ${task?.time}"

        return view
    }
}