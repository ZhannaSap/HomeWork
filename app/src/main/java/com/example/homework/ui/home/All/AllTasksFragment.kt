package com.example.homework.ui.home.All

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework.R
import com.example.homework.databinding.FragmentAllTasksBinding
import com.example.homework.ui.home.HomeFragmentDirections
import com.example.homework.ui.notifications.ListAdapter
import com.example.homework.ui.notifications.ListTasks


class AllTasksFragment : Fragment() {

    private var _binding: FragmentAllTasksBinding? = null
    private val binding get() = _binding!!

    private val tasks = ArrayList<ListTasks>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ListAdapter(tasks) { position ->
            navigateToTaskEditFragment("", position, false)
        }

        binding.taskList.adapter = adapter
        binding.taskList.layoutManager = LinearLayoutManager(requireContext())

        binding.addButton.setOnClickListener {
            navigateToTaskEditFragment("", tasks.size, true)
        }

        tasks.add(ListTasks("Написать курсавую", position = tasks.size))
        tasks.add(ListTasks("сходить в колледж", position = tasks.size))
        tasks.add(ListTasks("уволиться", position = tasks.size))
        tasks.add(ListTasks("купить крысу", position = tasks.size))
        tasks.add(ListTasks("убраться в комнате", position = tasks.size))
        tasks.add(ListTasks("сходить в магазин", position = tasks.size))
        tasks.add(ListTasks("покармить кота", position = tasks.size))
        tasks.add(ListTasks("ничего", position = tasks.size))
        tasks.add(ListTasks("убраться в комнате", position = tasks.size))

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
