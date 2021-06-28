package com.example.school21.data.model

import com.google.gson.annotations.SerializedName

class User(
    val login: String,
    val email: String,
    val location: String?,
    val wallet: Int,
    val phone: String?,
    val campus: List<Campus>,
    @SerializedName("image_url")
    val image: String,
    @SerializedName("displayname")
    val fullName: String,
    @SerializedName("correction_point")
    val points: Int,
    @SerializedName("curses_users")
    val courses: List<Course>,
    @SerializedName("projects_users")
    val projects: List<Project>
)