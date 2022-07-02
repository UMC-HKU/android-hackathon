package com.example.hkueverytime

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "PostTable")
data class Post (
    @SerializedName(value = "title") var title: String? = "",
    @SerializedName(value = "content") var content: String? = ""

)