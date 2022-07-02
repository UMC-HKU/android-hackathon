package com.example.hkueverytime

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "CommentTable")
data class Comment(
    @SerializedName(value = "postIdx") var postIdx:  Int,
    @SerializedName(value = "content") var content: String? = ""
)
