package com.example.hkueverytime

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UploadRetrofitInterface {
    @POST("/posts")
    fun write(@Body post: Post): Call<WriteResponse>

    /*@POST("/comments")
    fun writeComment(@Body comment: Comment): Call<CommentResponse>*/

}