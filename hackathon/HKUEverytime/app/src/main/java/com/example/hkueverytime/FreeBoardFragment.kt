package com.example.hkueverytime

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hkueverytime.databinding.ActivityMainBinding
import com.example.hkueverytime.databinding.FragmentFreeBinding
import com.google.gson.Gson

class FreeBoardFragment : Fragment(), PostView {
    private lateinit var binding: FragmentFreeBinding
    private lateinit var freeBoardRVAdapter: FreeBoardRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFreeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        getPosts()
        setupFloatingActionButton()
    }

    private fun initRecyclerView(result: List<Posts>) {
        freeBoardRVAdapter = FreeBoardRVAdapter(requireContext(), result)

        binding.freeBoardRecyclerView.adapter = freeBoardRVAdapter

        freeBoardRVAdapter.setMyItemClickListener(object : FreeBoardRVAdapter.MyItemClickListener{
            override fun onItemClick(post: Posts) {
                changePostFragment(post)
            }
        })
    }

    private fun getPosts() {
        val postService = PostService()
        postService.setPostView(this)

        postService.getPosts()
    }

    private fun changePostFragment(freeBoard: Posts) {
        (context as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, PostFragment().apply {
                arguments = Bundle().apply {
                    val gson = Gson()
                    val postJson = gson.toJson(freeBoard)
                    putString("post", postJson)
                }
            })
            .commitAllowingStateLoss()
    }


    private fun setupFloatingActionButton() {
        binding.fab.setOnClickListener {
            val intent = Intent (getActivity(), WriteActivity::class.java)
            getActivity()?.startActivity(intent)
        }

    }

    override fun onGetPostSuccess(code: Int, result: List<Posts>) {
        initRecyclerView(result)
    }

    override fun onGetPostFailure(code: Int, message: String) {
        Log.d("FreeBoard/POST-RESPONSE", message)
    }

}