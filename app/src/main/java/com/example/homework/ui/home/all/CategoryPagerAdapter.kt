package com.example.homework.ui.home.all


import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homework.ui.notifications.ListTasks

class CategoryPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: androidx.lifecycle.Lifecycle,
    private val list: ArrayList<ListTasks>
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private var fragments = arrayListOf(
        AllTasksFragment(list),
        CategoryAFragment(list),
        CategoryBFragment(list),
    )

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllTasksFragment(list)
            1 -> CategoryAFragment(list)
            2 -> CategoryBFragment(list)
            else -> AllTasksFragment(list)
        }
    }
}
