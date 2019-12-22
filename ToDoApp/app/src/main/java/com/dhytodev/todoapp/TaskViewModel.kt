package com.dhytodev.todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

/**
 * Created by DhytoDev on 2019-12-21.
 * Email : dhytodev@gmail.com
 */
class TaskViewModel(
    private val database: TaskDatabase
) : ViewModel() {

    fun addNewTask(task: Task) =
        database.taskDao().insertTask(task)

    fun getAllTasks(): LiveData<List<Task>> =
        database.taskDao().getTasks()
}

