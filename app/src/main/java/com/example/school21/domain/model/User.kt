package com.example.school21.domain.model

class User (
    val email: String,
    val login: String,
    val phone: String?,
    val fullName: String,
    val image: String,
    val wallet: Int,
    val points: Int,
    val courses: List<Course>,
    val isActive: Boolean
)