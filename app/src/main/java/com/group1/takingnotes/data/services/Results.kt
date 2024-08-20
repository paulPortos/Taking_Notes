package com.group1.takingnotes.data.services

sealed class Results<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Results<T>(data)
    class Error<T>(message: String, data: T? = null) : Results<T>(data, message)

}