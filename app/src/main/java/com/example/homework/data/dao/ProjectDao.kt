package com.example.homework.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.homework.R
import com.example.homework.data.entities.Project
import com.example.homework.data.entities.ProjectAndNotes
import com.example.homework.data.entities.ProjectTypes

@Dao
interface ProjectDao {
    @Insert
    fun add(project: Project)

    @Delete
    fun remove(project: Project)

    @Update
    fun update(project: Project)

    @Query("SELECT * FROM project")
    fun getProjects(): List<Project>

    @Transaction
    @Query("SELECT * FROM project")
    fun getProjectsWithNotes():LiveData<List<ProjectAndNotes>>
    @Query("SELECT * FROM project WHERE project_type=:projectTypes")
    fun getProjectsByType(projectTypes: ProjectTypes): LiveData<List<ProjectAndNotes>>
}