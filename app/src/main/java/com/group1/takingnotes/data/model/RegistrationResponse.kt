package com.group1.takingnotes.data.model

data class RegistrationResponse (
    val message: String, val user: User, val token: String
)