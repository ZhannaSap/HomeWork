package com.example.homework.ui.home.All

import com.example.homework.R


// CategoryAFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework.databinding.FragmentCategoryABinding
import com.example.homework.ui.home.HomeFragmentDirections
import com.example.homework.ui.notifications.ListAdapter
import com.example.homework.ui.notifications.ListTasks

class CategoryAFragment : Fragment() {

    private var _binding: FragmentCategoryABinding? = null
    private val binding get() = _binding!!

    private val tasksA = ArrayList<ListTasks>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ListAdapter(tasksA) { position ->
            navigateToTaskEditFragment("", position, false)
        }

        binding.taskList.adapter = adapter
        binding.taskList.layoutManager = LinearLayoutManager(requireContext())

        binding.addButton.setOnClickListener {
            navigateToTaskEditFragment("", tasksA.size, true)
        }

        tasksA.add(ListTasks("Написать курсавую", position = tasksA.size))
        tasksA.add(ListTasks("сходить в колледж", position = tasksA.size))
        tasksA.add(ListTasks("уволиться", position = tasksA.size))
        tasksA.add(ListTasks("купить крысу", position = tasksA.size))
        tasksA.add(ListTasks("убраться в комнате", position = tasksA.size))

        adapter.notifyDataSetChanged()
    }

    private fun navigateToTaskEditFragment(taskDescription: String, position: Int, addTask: Boolean) {
        val action = HomeFragmentDirections.actionNavigationHomeToTaskEditFragment(
            argtext = taskDescription,
            position = position,
            addtask = addTask
        )
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
