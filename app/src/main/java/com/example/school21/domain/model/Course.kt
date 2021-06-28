package com.example.school21.domain.model

class Course(
    val level: Double,
    val skill: List<Skill>,
    val hasCoalition: Boolean,
    val name: String,
    val coalition: Coalition
)