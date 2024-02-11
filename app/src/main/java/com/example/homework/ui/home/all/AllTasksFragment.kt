package com.example.homework.ui.home.all

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework.databinding.FragmentAllTasksBinding
import com.example.homework.ui.home.HomeFragmentDirections
import com.example.homework.ui.notifications.ListAdapter
import com.example.homework.ui.notifications.ListTasks


class AllTasksFragment(val listTasks: ArrayList<ListTasks>) : Fragment() {

    private var _binding: FragmentAllTasksBinding? = null
    private val binding get() = _binding!!

  //  private val tasks = ArrayList<ListTasks>()
  val adapter = ListAdapter(listTasks) { position ->
      navigateToTaskEditFragment("", position, false)
  }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.taskList.adapter = adapter
        binding.taskList.layoutManager = LinearLayoutManager(requireContext())

        binding.addButton.setOnClickListener {
            navigateToTaskEditFragment("", listTasks.size, true)
        }
        adapter.addTasks(listTasks)
            //adapter.notifyDataSetChanged()
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
