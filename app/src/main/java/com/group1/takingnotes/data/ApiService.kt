package com.group1.takingnotes.data

import com.group1.takingnotes.data.model.RegistrationRequest
import com.group1.takingnotes.data.model.RegistrationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    //@POST("login")
    //suspend fun loginUser(@Body request: LoginRequest): Response<LoginResponse>

    @POST("register")
    fun registerUser(@Body request: RegistrationRequest): Response<RegistrationResponse>
}