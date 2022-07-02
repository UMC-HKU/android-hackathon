package com.example.hkueverytime

import com.google.gson.annotations.SerializedName

data class WriteResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: Result?
)

data class Result(
    @SerializedName("postIdx") val postIdx: Int,
)