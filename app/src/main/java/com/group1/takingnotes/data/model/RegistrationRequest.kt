package com.group1.takingnotes.data.model

import com.google.gson.annotations.SerializedName

data class RegistrationRequest (
    var username: String, var password: String,
    @SerializedName("password_confirmation")
    var passwordConfirmation:String
)