package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*
import java.text.SimpleDateFormat
import java.util.*


class ToDoAdapter(val list:List<TodoModel>):RecyclerView.Adapter<ToDoAdapter.TodoViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
       return TodoViewHolder(LayoutInflater.from(parent.context)
           .inflate(R.layout.item_todo,parent,false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun getItemId(position: Int): Long {
        return list[position].id
    }
    class TodoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(todoModel: TodoModel) {
           with(itemView) {
               val colors =resources.getIntArray(R.array.random_color)
               val randomColor = colors[Random().nextInt(colors.size)]
               viewColoring.setBackgroundColor(randomColor)
               txtShowTitle.text=todoModel.title
               txtShowTask.text=todoModel.description
               txtShowCategory.text=todoModel.category
               updateTime(todoModel.time)
               updateDate(todoModel.date)

           }
        }

        private fun updateTime(time: Long) {
         val myFormat = "h:mm a"
            val sdf = SimpleDateFormat(myFormat)
            itemView.txttime.text=sdf.format(Date(time))
        }

        private fun updateDate(date: Long) {
            val myFormat = "EEE, d MMM yyyy"
            val sdf = SimpleDateFormat(myFormat)
            itemView.txtdate.text=sdf.format(Date(date))
        }

    }
}