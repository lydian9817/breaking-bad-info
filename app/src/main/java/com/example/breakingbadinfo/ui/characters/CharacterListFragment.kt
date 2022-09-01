package com.example.breakingbadinfo.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.breakingbadinfo.databinding.FragmentCharacterListBinding
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.breakingbadinfo.R

class CharacterListFragment : Fragment(){
    private val viewModel: CharacterViewModel by activityViewModels()

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
        binding.characterNameRv.adapter = CharacterListAdapter(CharacterListener { character ->
            viewModel.onCharacterClicked(character)
            goToNextScreen()
        })

        return binding.root
    }

    /**Goes to detail fragment*/
    fun goToNextScreen() {
        findNavController().navigate(R.id.action_characterListFragment_to_characterDetailFragment)
    }
}