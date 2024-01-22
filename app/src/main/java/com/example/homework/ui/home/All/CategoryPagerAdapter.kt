
package com.example.homework.ui.home.All

import androidx.fragment.app.Fragment


import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homework.ui.home.All.AllTasksFragment
import com.example.homework.ui.home.All.CategoryAFragment
import com.example.homework.ui.home.All.CategoryBFragment

class CategoryPagerAdapter (
    fragmentManager: FragmentManager,
    lifecycle: androidx.lifecycle.Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllTasksFragment()
            1 -> CategoryAFragment()
            2 -> CategoryBFragment()
            else -> AllTasksFragment()
        }
    }
}
