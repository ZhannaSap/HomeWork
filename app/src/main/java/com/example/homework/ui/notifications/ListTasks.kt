package com.example.homework.ui.notifications


data class ListTasks(
    var name: String,
    var position: Int,
    var category: String? = null,
    var isCompleted:Boolean?=false,
)