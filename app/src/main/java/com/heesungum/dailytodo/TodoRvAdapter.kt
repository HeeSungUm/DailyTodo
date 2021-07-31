package com.heesungum.dailytodo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heesungum.dailytodo.databinding.ItemTodoBinding

class TodoRvAdapter(private val context: Context): RecyclerView.Adapter<TodoRvAdapter.Holder>() {
    var todos: List<Todo> = listOf()

    inner class Holder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(todo: Todo){
            binding.todo = todo
            binding.todoTitle.text = todo.title
            binding.todoCheckbox.isChecked = todo.isChecked
            binding.activity = context as MainActivity
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(context), parent, false)

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        todos[position].let { holder.onBind(it) }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    fun setData(todos: List<Todo>){
        this.todos = todos
        notifyDataSetChanged()
    }
}