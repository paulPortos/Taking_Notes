package com.group1.takingnotes.data.services

import com.group1.takingnotes.data.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun postUserDataList(): Flow<Result<List<User>>>
}