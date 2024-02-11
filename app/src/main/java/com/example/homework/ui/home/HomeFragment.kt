package com.example.homework.ui.home

import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.lifecycleScope
import com.example.homework.databinding.FragmentHomeBinding
import com.example.homework.ui.home.all.CategoryPagerAdapter
import com.example.homework.ui.notifications.ListAdapter
import com.example.homework.ui.notifications.ListTasks
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val tasks = ArrayList<ListTasks>()
    private lateinit var auth: FirebaseAuth
   /* private val adapterHome = ListAdapter(tasks,this::onClick)

    private fun onClick(position: Int) {

    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        Log.e("ololo", "onViewCreated: $auth", )

        var taskDesc = arguments?.getString("argtext")
        var selectedRadioButtonText = arguments?.getString("selectedRadioButtonText")
        var position = arguments?.getInt("position")
        taskDesc?.let {taskDesc->
            selectedRadioButtonText?.let {category->
                if (position != null) {
                    addNewTask(taskDesc,category, position)
                }
            }
        }

 /*       setFragmentResultListener(TaskEditFragment.KEY1) { _, bundle ->
            Log.e("ololo", "HomeFragment: setFragmentResultListener is working", )
            val resultText = bundle.getString("argtext", "")
            val selectedRadioButtonText = bundle.getString("selectedRadioButtonText", "")
            val position = bundle.getInt("position", -1)
            val addTask = bundle.getBoolean("addtask", false)
            Log.e("ololo", "Task Description: $resultText $selectedRadioButtonText")
           // Log.e("ololo", "onViewCreated: $tasks", )

            if (resultText.isNotEmpty()) {
                if (addTask) {
                    addNewTask(resultText, selectedRadioButtonText)
                } else {
                    updateExistingTask(resultText, position, selectedRadioButtonText)
                }
              //  updateRecyclerView()
            }

        }*/

        val adapter = CategoryPagerAdapter(
            childFragmentManager,
            lifecycle,
            tasks
        )
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "ALL"
                1 -> "DONE"
                2 -> "UNDONE"
                else -> "ALL"
            }
        }.attach()
        Log.e("ololo", "onViewCreated: $tasks", )
    }

    private fun addNewTask(resultText: String, selectedRadioButtonText: String,position:Int) {
        val newTask = ListTasks(
            name = resultText,
            category = selectedRadioButtonText,
            position = position,
            isCompleted = selectedRadioButtonText == "Done"
        )
        tasks.add(newTask)
      /*  updateRecyclerView()
        binding.taskRecyclerView.adapter = adapterHome*/
    }

/*    private fun updateExistingTask(
        resultText: String,
        position: Int,
        selectedRadioButtonText: String
    ) {
        val taskUpdate = tasks[position]
        taskUpdate.name = resultText
        taskUpdate.category = selectedRadioButtonText
        taskUpdate.isCompleted = selectedRadioButtonText == "Done"
      //  updateRecyclerView()
    }*/

  /* private fun updateRecyclerView() {
        lifecycleScope.launch {
            binding.taskRecyclerView.adapter?.notifyDataSetChanged()
        }
    }*/
}


/*val completedTasks = tasks.filter { it.isCompleted }
// Фильтруем невыполненные задачи
val incompleteTasks = tasks.filter { !it.isCompleted }*/