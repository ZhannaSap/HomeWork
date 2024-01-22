package com.example.homework.ui.notifications


import androidx.recyclerview.widget.RecyclerView
import com.example.homework.databinding.ItemListBinding

class ListViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(task: ListTasks) {
        with(binding) {
            itemListTask.text = task.name

        }
    }
}