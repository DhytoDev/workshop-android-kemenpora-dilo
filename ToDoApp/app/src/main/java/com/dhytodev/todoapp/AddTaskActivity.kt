package com.dhytodev.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_task.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddTaskActivity : AppCompatActivity() {

    private val taskViewModel: TaskViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        buttonSaveTask.setOnClickListener {
            saveTask()
            finish()
        }
    }

    private fun saveTask() {
        val taskName = textInputTask.text.toString()
        val task = Task(task = taskName)

        taskViewModel.addNewTask(task)

    }
}
