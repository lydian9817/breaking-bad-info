package com.example.breakingbadinfo

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbadinfo.network.Character
import com.example.breakingbadinfo.overview.CharacterNameAdapter

//bindingadapter for the RecyclerView
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<Character>?) {
    val adapter = recyclerView.adapter as CharacterNameAdapter
    adapter.submitList(data)

}