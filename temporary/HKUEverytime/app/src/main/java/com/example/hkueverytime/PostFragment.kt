package com.example.hkueverytime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hkueverytime.databinding.ActivityPostBinding
import com.google.gson.Gson

class PostFragment : Fragment() {
    private lateinit var binding: ActivityPostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityPostBinding.inflate(inflater,container,false)

        val postData = arguments?.getString("post")
        val gson = Gson()

        val post = gson.fromJson(postData, Post::class.java)

        setViews(post)
        setClickListeners(post)


        return binding.root
    }

    private fun setViews(freeBoard: Post) {
        binding.postTv.text = freeBoard.title.toString()
        binding.contentTv.text = freeBoard.content.toString()
    }

    private fun setClickListeners(freeBoard: Post) {
        //set click listener
        binding.postReturnIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, FreeBoardFragment())
                .commitAllowingStateLoss()
        }
    }

}