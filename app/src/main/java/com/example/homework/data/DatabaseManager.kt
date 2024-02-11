package com.example.homework.data

import android.content.Context
import androidx.room.Room
import com.example.homework.data.dao.NoteDao
import com.example.homework.data.dao.ProjectDao
import com.example.homework.data.db.AppDatabase

object DatabaseManager {

    lateinit var noteDao: NoteDao
    lateinit var projectDao: ProjectDao

    fun init(context: Context){
        val database = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "notes"
        )
            .allowMainThreadQueries()
            .build()

        noteDao = database.noteDao()
        projectDao = database.projectDao()
    }
}