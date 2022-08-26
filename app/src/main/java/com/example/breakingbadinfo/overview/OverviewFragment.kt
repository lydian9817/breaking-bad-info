package com.example.breakingbadinfo.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.breakingbadinfo.databinding.FragmentOverviewBinding
import androidx.fragment.app.viewModels

class OverviewFragment : Fragment(){
    private val viewModel: OverviewViewModel by viewModels()

    /** Inflates the layout using data binding*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        //allows Data Binding to observe LiveData
        binding.lifecycleOwner = this

        //gives binding acces to the viewModel
        binding.viewModel = viewModel

        return binding.root
    }
}