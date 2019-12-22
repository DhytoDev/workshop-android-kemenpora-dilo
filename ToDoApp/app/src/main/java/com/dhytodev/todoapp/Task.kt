package com.dhytodev.todoapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val task : String,
    val completed : Boolean = false
)