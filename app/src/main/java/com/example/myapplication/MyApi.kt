package com.example.myapplication

import retrofit2.Response
import retrofit2.http.GET

interface MyApi {

    @GET("/3/discover/movie?22=&api_key=${Constant.api_key}")
    suspend fun getApiInput(): Response<MovieData>
}