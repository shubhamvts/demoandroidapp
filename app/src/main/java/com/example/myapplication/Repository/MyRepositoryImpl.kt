package com.example.myapplication.Repository

import android.util.Log
import com.example.myapplication.MovieData
import com.example.myapplication.MyApi

class MyRepositoryImpl(
    private val api: MyApi
): MyRepository {

    override suspend fun getData(): MovieData? {
        var movieData: MovieData? = null
        val response = api.getApiInput()
        if (response.isSuccessful && response.body() != null) {
            movieData = response.body()
        }
        return movieData
    }
}