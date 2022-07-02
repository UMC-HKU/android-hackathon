package com.example.hkueverytime

import retrofit2.Call
import retrofit2.http.GET

interface GetRetrofitInterface {
    @GET("/posts")
    fun getPosts(): Call<PostResponse>
}