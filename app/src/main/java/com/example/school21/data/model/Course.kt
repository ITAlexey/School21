package com.example.school21.data.model

import com.google.gson.annotations.SerializedName

class Course(
    val level: Double,
    val skills: List<Skill>,
    val hasCoalition: Boolean,
    @SerializedName("curses")
    val courseName: CourseName
)