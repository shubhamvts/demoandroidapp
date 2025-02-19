package com.example.myapplication.Repository

import com.example.myapplication.MovieData

interface MyRepository {

    suspend fun getData(): MovieData?
}