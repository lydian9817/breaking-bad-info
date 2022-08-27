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
    private val _names = MutableLiveData<Character>()
    //backing
    val names: LiveData<Character> = _names

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            try {
                _names.value = BreakingBadApi.retrofitService.getCharacters()[0]
                _status.value = "nombre ${_names.value!!.name}"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}