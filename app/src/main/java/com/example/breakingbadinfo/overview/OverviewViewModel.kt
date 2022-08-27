package com.example.breakingbadinfo.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbadinfo.network.BreakingBadApi
import com.example.breakingbadinfo.network.Character
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    //_status holds request results
    private val _status = MutableLiveData<String>()
    //backing
    val status: LiveData<String> = _status

    //name property
    private val _characterNames = MutableLiveData<Character>()
    //backing
    val characterNames: LiveData<Character> = _characterNames

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            try {
                _characterNames.value = BreakingBadApi.retrofitService.getCharacters()[0]
                _status.value = "nombre ${_characterNames.value!!.name}"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}