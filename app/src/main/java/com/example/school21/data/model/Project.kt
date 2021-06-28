package com.example.school21.data.model

import com.google.gson.annotations.SerializedName

class Project(
    val name: ProjectName,
    val status: String,
    @SerializedName("final_mark")
    val grade: Int?
)
