package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.MovieData
import com.example.myapplication.Repository.MyRepository
import com.example.myapplication.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
): ViewModel() {

    var displaytext:String = "Hello Hello"

    private val resultData = MutableStateFlow<List<Results>?>(listOf())
    val resultDataList = resultData

    fun getAllData() {
        var results: MovieData?
        viewModelScope.launch {
            results = repository.getData()
            resultData.value = results?.results
        }
    }
}