package com.example.breakingbadinfo

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbadinfo.network.Character
import com.example.breakingbadinfo.ui.characters.BreakingBadApiStatus
import com.example.breakingbadinfo.ui.characters.CharacterListAdapter

//bindingadapter for the RecyclerView
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<Character>?) {
    val adapter = recyclerView.adapter as CharacterListAdapter
    adapter.submitList(data)
}

//binding adapter for error handling imageView
@BindingAdapter("breakingBadApiStatus")
fun bindStatus(statusImageView: ImageView,
               status: BreakingBadApiStatus?) {
    when (status) {
        BreakingBadApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_baseline_cloud_queue_24)
        }
        BreakingBadApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_baseline_cloud_off_24)
        }
        else -> {
            statusImageView.visibility = View.GONE
        }
    }
}