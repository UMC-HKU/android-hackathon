package com.example.hkueverytime

interface PostView {
    fun onGetPostSuccess(code: Int, result: List<Posts>)
    fun onGetPostFailure(code: Int, message: String)
}