package com.example.homework.ui.onbording


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework.utils.MySharedPreferences
import com.example.homework.databinding.FragmentOnboardingBinding
import com.example.homework.ui.onbording.view_pager.OnBoardingAdapter


class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding

    private val adapter = OnBoardingAdapter(this::onClick)

    private  val  pref by lazy {
        MySharedPreferences(requireContext())
    }

    private fun onClick() {
        pref.setOnboardingShown()
        findNavController().navigateUp()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
    }


}