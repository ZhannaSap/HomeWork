package com.example.homework.ui.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.databinding.ItemListBinding
import com.example.homework.ui.home.HomeFragmentDirections

class ListAdapter(
    private val tasks: ArrayList<ListTasks>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.onBind(tasks[position])

        holder.itemView.setOnClickListener { view ->
            navigateToTaskEditFragment(view, tasks[position].name, position, false)
        }
    }

    private fun navigateToTaskEditFragment(view: View, taskDescription: String, position: Int, addTask: Boolean) {
        val action = HomeFragmentDirections.actionNavigationHomeToTaskEditFragment(
            argtext = taskDescription,
            position = position,
            addtask = addTask
        )
        Navigation.findNavController(view).navigate(action)
    }
}
