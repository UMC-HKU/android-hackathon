package com.example.hkueverytime

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hkueverytime.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity(), WriteView {

    lateinit var binding: ActivityWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.postSendIv.setOnClickListener {
            write()
            finish()
        }

        binding.postReturnIv.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, FreeBoardFragment())
                .commitAllowingStateLoss()
        }
    }

    private fun getPost(): Post {
        val title: String = binding.postTitleTiet.text.toString()
        val content: String = binding.postContentTiet.text.toString()

        return Post(title,content)
    }

    private fun write(){
        if (binding.postTitleTiet.text.toString().isEmpty()) {
            Toast.makeText(this, "제목을 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        else if (binding.postContentTiet.text.toString().isEmpty()) {
            Toast.makeText(this, "내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

       /* val writeService = getRetrofit().create(UploadRetrofitInterface::class.java)
        writeService.write(getPost()).enqueue(object: Callback<WriteResponse>{
            override fun onResponse(call: Call<WriteResponse>, response: Response<WriteResponse>) {
                Log.d("POST/SUCCESS", response.toString())
                val resp: WriteResponse = response.body()!!
                when(resp.code){
                    1000->finish()
                }
            }

            override fun onFailure(call: Call<WriteResponse>, t: Throwable) {
                Log.d("POST/FAILURE", t.message.toString())
            }
        })*/
        val writeService = WriteService()
        writeService.setWriteView(this)
        writeService.write(getPost())

    }
    override fun onWriteSuccess() {
        finish()
    }

    override fun onWriteFailure() {
        //실패처리
    }
}