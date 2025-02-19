package com.example.myapplication

data class MovieData(
    val page: Int,
    val results: List<Results>,
    val total_pages: Int,
    val total_results: Int
)