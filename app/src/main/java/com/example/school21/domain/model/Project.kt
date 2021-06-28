package com.example.school21.domain.model

import com.example.school21.domain.model.utils.ProjectStatus

class Project (
    val name: String,
    val status: ProjectStatus,
    val grade: Int
)