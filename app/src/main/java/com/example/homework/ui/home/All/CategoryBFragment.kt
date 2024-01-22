package com.example.homework.ui.home.All

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework.databinding.FragmentCategoryBBinding
import com.example.homework.ui.home.HomeFragmentDirections
import com.example.homework.ui.notifications.ListAdapter
import com.example.homework.ui.notifications.ListTasks

class CategoryBFragment : Fragment() {

    private var _binding: FragmentCategoryBBinding? = null
    private val binding get() = _binding!!

    private val tasksB = ArrayList<ListTasks>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ListAdapter(tasksB) { position ->
            navigateToTaskEditFragment("", position, false)
        }

        binding.taskList.adapter = adapter
        binding.taskList.layoutManager = LinearLayoutManager(requireContext())

        binding.addButton.setOnClickListener {
            navigateToTaskEditFragment("", tasksB.size, true)
        }

        tasksB.add(ListTasks("сходить в магазин", position = tasksB.size))
        tasksB.add(ListTasks("покармить кота", position = tasksB.size))
        tasksB.add(ListTasks("ничего", position = tasksB.size))
        tasksB.add(ListTasks("убраться в комнате", position = tasksB.size))


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
