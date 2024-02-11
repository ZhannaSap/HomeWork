package com.example.homework.ui.onbording.view_pager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.homework.databinding.ItemOnbordingBinding
import com.example.homework.model.Onbording
import com.example.homework.utils.loadImage

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val list = arrayListOf<Onbording>(
        Onbording("Добро пожаловать в Task Manager!", "Удобный инструмент для управления задачами и повышения производительности.", "https://dspncdn.com/a1/media/originals/6f/f3/51/6ff35161e8ddf3b77a089c434953e83c.jpg"),
        Onbording("Основные возможности приложения", "Создавайте задачи и проекты.\n" +
                "Устанавливайте сроки и приоритеты.\n" +
                "Отмечайте задачи как выполненные.\n" +
                "Просматривайте статистику производительности.", "https://www.playmeo.com/wp-content/uploads/2021/06/Planning-Board-for-sequencing-programs-shutterstock_615691754.png"),
        Onbording("Как вам поможет Task Manager?", "Увеличьте свою эффективность.\n" +
                "Никогда не забудьте о важных задачах.\n" +
                "Организуйте свои проекты более эффективно.", "https://www.pinclipart.com/picdir/big/409-4092024_get-started-for-free-clipart.png")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnbordingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnbordingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoarding: Onbording) = with(binding) {
            tvTitle.text = onBoarding.title
            tvDesc.text = onBoarding.desc
            tvSkip.isVisible = adapterPosition != list.lastIndex
            btnGetStarted.isVisible = adapterPosition == list.lastIndex
            ivBoard.loadImage(onBoarding.image.toString())

            btnGetStarted.setOnClickListener {
                onClick()
            }
            tvSkip.setOnClickListener {
                onClick()
            }

        }


    }

}