package com.dhytodev.todoapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val taskViewModel: TaskViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insertTasks()
        observeTasks()
    }

    private fun insertTasks() {
        val task1 = Task(1, "Belajar Android")
        val task2 = Task(2, "Belajar Java", true)

        taskViewModel.addNewTask(task1)
        taskViewModel.addNewTask(task2)
        
    }

    private fun observeTasks() {
        taskViewModel.getAllTasks().observe(this, Observer {
            if(it.isNotEmpty()) {
                it.map {
                    Log.d("tasks", it.toString())
                }
            }
        })
    }
}
