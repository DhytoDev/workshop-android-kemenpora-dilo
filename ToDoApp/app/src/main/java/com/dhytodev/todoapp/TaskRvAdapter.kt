package com.dhytodev.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_task_item.view.*

/**
 * Created by DhytoDev on 2019-12-22.
 * Email : dhytodev@gmail.com
 */
class TaskRvAdapter : RecyclerView.Adapter<TaskRvAdapter.TaskViewHolder>() {

    var listTasks = listOf<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_task_item, parent, false)

        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int = listTasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = listTasks[position]

        holder.bindView(task)
    }

    inner class TaskViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bindView(task: Task) {
            itemView.apply {
                textTaskName.text = task.task
                checkboxComplete.isChecked = task.completed
            }
        }
    }
}