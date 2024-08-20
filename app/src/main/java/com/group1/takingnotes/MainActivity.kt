package com.group1.takingnotes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.group1.takingnotes.data.ApiService
import com.group1.takingnotes.data.ApiLaravel
import com.group1.takingnotes.data.model.RegistrationRequest
import com.group1.takingnotes.data.model.RegistrationResponse

class MainActivity : AppCompatActivity() {

    private lateinit var btnSignup: Button
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnForgot: Button
    private lateinit var btnLoginNow: Button
    private lateinit var togglePassword: ImageView
    private lateinit var apiService: ApiService
    private var isPasswordVisible = false
    @SuppressLint("MissingInflatedId")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignup = findViewById(R.id.btnSignUp)
        etUsername = findViewById(R.id.etusername)
        etPassword = findViewById(R.id.etpassword)
        btnForgot = findViewById(R.id.btnforgot)
        btnLoginNow = findViewById(R.id.btnloginnow)
        togglePassword = findViewById(R.id.ivTogglePassword)

        apiService = ApiLaravel.createService(ApiService::class.java)

        this.btnLoginNow.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()


        }

        this.togglePassword.setOnClickListener {
            togglePasswordVisibility(isPasswordVisible)
        }

        // SIGN UP
        this.btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registerUser(name: String, password: String, passwordConfirmation: String){
        val registerRequest = RegistrationRequest(name, password, passwordConfirmation)
        val call = apiService.registerUser(registerRequest)

        call.enqueue(object : retrofit2.Callback<RegistrationResponse>
    }

    private fun togglePasswordVisibility(isPasswordVisible: Boolean){
        this.isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible){
                // Show Password
                this.etPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                this.togglePassword.setImageResource(R.drawable.ic_visibility_on) // Update to your "visible" icon
            } else {
                // Hide Password
                this.etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                this.togglePassword.setImageResource(R.drawable.ic_visibility_off) // Update to your "invisible" icon
            }
            // Move the cursor to the end of the text
            this.etPassword.setSelection(etPassword.text.length)
    }
}