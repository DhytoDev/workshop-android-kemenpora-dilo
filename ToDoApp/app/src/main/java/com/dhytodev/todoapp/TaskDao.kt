package com.dhytodev.todoapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Query("SELECT * FROM tasks")
    fun getTasks() : LiveData<List<Task>>

    @Query("UPDATE tasks SET completed = :isComplete WHERE id = :id ")
    fun updateTask(isComplete: Boolean, id: Int)

//    @Update
//    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("DELETE FROM tasks")
    fun clearTasks()
}