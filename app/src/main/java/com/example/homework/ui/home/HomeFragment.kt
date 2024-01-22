package com.example.homework.ui.home

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.homework.databinding.FragmentHomeBinding
import com.example.homework.ui.notifications.ListTasks
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val tasks = ArrayList<ListTasks>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener(TaskEditFragment.KEY1) { _, bundle ->
            val resultText = bundle.getString("argtext", "")
            val position = bundle.getInt("position", -1)
            val addTask = bundle.getBoolean("addtask", false)

            if (resultText.isNotEmpty()) {
                if (addTask) {
                    addNewTask(resultText)
                } else {
                    updateExistingTask(resultText, position)
                }
            }
        }
    }

    private fun addNewTask(resultText: String) {
        val newTask = ListTasks(
            name = resultText,
            position = tasks.size
        )
        tasks.add(newTask)
        updateRecyclerView()
    }

    private fun updateExistingTask(resultText: String, position: Int) {
        val taskUpdate = tasks[position]
        taskUpdate.name = resultText
        updateRecyclerView()
    }

    private fun updateRecyclerView() {
        lifecycleScope.launch {
            binding.taskRecyclerView.adapter?.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
