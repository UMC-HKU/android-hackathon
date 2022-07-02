package com.example.hkueverytime

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WriteService {
    private lateinit var writeView: WriteView

    fun setWriteView(writeView: WriteView) {
        this.writeView = writeView
    }

    fun write(post: Post) {

        val writeService = getRetrofit().create(UploadRetrofitInterface::class.java)

        writeService.write(post).enqueue(object: Callback<WriteResponse>{
            override fun onResponse(call: Call<WriteResponse>, response: Response<WriteResponse>) {
                if (response.isSuccessful && response.code() == 200) {
                    val writeResponse: WriteResponse = response.body()!!
                    Log.d("WRITE-RESPONSE", writeResponse.toString())

                    when (val code = writeResponse.code) {
                        1000 -> writeView.onWriteSuccess()
                    }
                } else {
                    val writeResponse: WriteResponse = response.body()!!
                    Log.d("WRITE-RESPONSE", writeResponse.toString())
                }
            }

            override fun onFailure(call: Call<WriteResponse>, t: Throwable) {
                //실패처리
                writeView.onWriteFailure()
            }
        })
    }
}