package com.example.breakingbadinfo.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbadinfo.network.BreakingBadApi
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    //_status holds request results
    private val _status = MutableLiveData<String>()
    //backing property
    val status: LiveData<String> = _status

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            try {
                val listResult = BreakingBadApi.retrofitService.getCharacters()
                _status.value = "Success: ${listResult.size} characters retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}