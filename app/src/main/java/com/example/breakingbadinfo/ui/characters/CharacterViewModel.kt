package com.example.breakingbadinfo.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbadinfo.network.BreakingBadApi
import com.example.breakingbadinfo.network.Character
import kotlinx.coroutines.launch

enum class BreakingBadApiStatus { LOADING, ERROR, DONE }

class CharacterViewModel : ViewModel() {

    //_status holds request results
    private val _status = MutableLiveData<BreakingBadApiStatus>()
    //backing
    val status: LiveData<BreakingBadApiStatus> = _status

    //character object property
    private val _characters = MutableLiveData<List<Character>>()
    //backing
    val characters: LiveData<List<Character>> = _characters

    //single clicked character
    private val _character = MutableLiveData<Character>()
    //backing
    val character: LiveData<Character> = _character

    init {
        getCharacters()
    }

    //get characters list
    private fun getCharacters() {
        viewModelScope.launch {
            _status.value = BreakingBadApiStatus.LOADING
            try {
                _characters.value = BreakingBadApi.retrofitService.getCharacters()
                _status.value = BreakingBadApiStatus.DONE
            } catch (e: Exception) {
                _status.value = BreakingBadApiStatus.ERROR
                _characters.value = listOf() //cleans the recycler view
            }
        }
    }

    //set binding for the clicked Character object
    fun onCharacterClicked(character: Character) {
        _character.value = character
    }
}