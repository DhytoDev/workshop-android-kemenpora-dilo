package com.dhytodev.todoapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val taskViewModel: TaskViewModel by viewModel()
    private val taskRvAdapter: TaskRvAdapter by lazy {
        TaskRvAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        insertTasks()
        observeTasks()
    }

    private fun initView() {
         recyclerViewTasks.apply {
             layoutManager = LinearLayoutManager(this@MainActivity)
             adapter = taskRvAdapter
         }
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
                taskRvAdapter.listTasks = it
                taskRvAdapter.notifyDataSetChanged()
            }
        })
    }
}
