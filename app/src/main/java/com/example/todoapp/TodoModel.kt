package com.example.todoapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoModel (
    var title:String,
    var description:String,
    var category:String,
    var date:Long,
    var time:Long,
    var isFinished:Int=0,
    // kept at last as other first when we create a ToDomodrl object first parameter will be id which we dont want
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
    )