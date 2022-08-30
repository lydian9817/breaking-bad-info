package com.example.breakingbadinfo.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.breakingbadinfo.databinding.FragmentCharacterListBinding
import androidx.fragment.app.viewModels

class CharacterListFragment : Fragment(){
    private val viewModel: CharacterViewModel by viewModels()

    /** Inflates the layout using data binding*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCharacterListBinding.inflate(inflater)

        //allows Data Binding to observe LiveData
        binding.lifecycleOwner = this

        //gives binding access to the viewModel
        binding.viewModel = viewModel

        //initialize the adapter
        binding.characterNameRv.adapter = CharacterListAdapter()

        return binding.root
    }
}