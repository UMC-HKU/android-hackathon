package com.example.hkueverytime

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostService() {
    private lateinit var postView: PostView

    fun setPostView(postView: PostView) {
        this.postView = postView
    }

    fun getPosts() {
        val postService = getRetrofit().create(GetRetrofitInterface::class.java)

        postService.getPosts().enqueue(object : Callback<PostResponse> {
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                if (response.isSuccessful && response.code() == 200) {
                    val postResponse: PostResponse = response.body()!!

                    Log.d("POST-RESPONSE", postResponse.toString())

                    when (val code = postResponse.code) {
                        1000 -> {
                            postView.onGetPostSuccess(code, postResponse.result!!)
                        }

                        else -> postView.onGetPostFailure(code, postResponse.message)
                    }
                }
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                t.message?.let { postView.onGetPostFailure(t.hashCode(), it) }
            }
        })
    }
}
