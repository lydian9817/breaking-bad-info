package com.example.breakingbadinfo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.breakingbadinfo.R
import com.example.breakingbadinfo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHomeBinding.inflate(inflater)

        binding.characterButton.setOnClickListener { goToCharacterScreen() }

        return binding.root

    }

    fun goToCharacterScreen() {
        findNavController().navigate(R.id.action_homeFragment_to_characterListFragment)
    }
}