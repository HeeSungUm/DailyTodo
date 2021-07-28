package com.heesungum.dailytodo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.heesungum.dailytodo.databinding.ItemTodoBinding
import kotlin.coroutines.coroutineContext

class TodoRvAdapter(private val context: Context, var data: LiveData<List<Todo>>): RecyclerView.Adapter<TodoRvAdapter.Holder>() {

    inner class Holder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(todo: Todo){
            binding.todoTitle.text = todo.title
            binding.todoCheckbox.isChecked = todo.isChecked
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(context), parent, false)

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        data.value?.get(position)?.let { holder.onBind(it) }
    }

    override fun getItemCount(): Int {
        return data.value!!.size
    }
}