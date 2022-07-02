package com.example.hkueverytime

import com.google.gson.annotations.SerializedName

data class PostResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: List<Posts>
)

data class Posts(
    @SerializedName("postIdx") val postIdx : Int,
    @SerializedName("title") val title : String,
    @SerializedName("content") val content : String,
    @SerializedName("commentCount") val commentCount: Int,
    @SerializedName("createdAt") val createdAt : String
)