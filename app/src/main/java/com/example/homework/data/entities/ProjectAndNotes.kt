package com.example.homework.data.entities

import androidx.room.Embedded
import androidx.room.Relation

data class ProjectAndNotes(
    @Embedded val project: Project,
    @Relation(
        parentColumn = "project_id",
        entityColumn = "project_id"
    )
    val noteList: List<Note>
)