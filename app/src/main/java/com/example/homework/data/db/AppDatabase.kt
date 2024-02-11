package com.example.homework.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework.data.dao.NoteDao
import com.example.homework.data.dao.ProjectDao
import com.example.homework.data.entities.Note
import com.example.homework.data.entities.Project

@Database(
    entities = [Note::class, Project::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun projectDao(): ProjectDao
}