package com.example.hkueverytime

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hkueverytime.databinding.ItemFreeBinding

class FreeBoardRVAdapter(val context: Context,val result : List<Posts>): RecyclerView.Adapter<FreeBoardRVAdapter.ViewHolder>() {

    // 클릭 인터페이스 정의
    interface MyItemClickListener{
        fun onItemClick(post: Posts)
    }

    // 리스너 객체를 전달받는 함수랑 리스너 객체를 저장할 변수
    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    inner class ViewHolder(val binding : ItemFreeBinding) : RecyclerView.ViewHolder(binding.root) {
        /*fun bind(post: Posts) {
            binding.itemBoardTitleTv.text = post.title
            binding.itemBoardContentTv.text = post.content
            //number of comments? time?
        }*/

        val title : TextView = binding.itemBoardTitleTv
        val content : TextView = binding.itemBoardContentTv

    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int,
    ): FreeBoardRVAdapter.ViewHolder {
        val binding : ItemFreeBinding = ItemFreeBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FreeBoardRVAdapter.ViewHolder, position: Int) {
        holder.title.text = result[position].title
        holder.content.text = result[position].content

        //holder.bind(result.posts[position])
        holder.itemView.setOnClickListener { mItemClickListener.onItemClick(result[position]) }
    }

    override fun getItemCount(): Int = result.size
}