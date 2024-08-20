package com.group1.takingnotes

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.group1.takingnotes.data.ApiLaravel
import com.group1.takingnotes.data.ApiService
import com.group1.takingnotes.data.model.RegistrationRequest
import com.group1.takingnotes.data.model.RegistrationResponse
import retrofit2.Call

class SignupActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var togglePassword: ImageView
    private lateinit var toggleConfirmPassword: ImageView
    private lateinit var btnSignUpNow: Button
    private lateinit var btnSignIn: Button
    private lateinit var apiService: ApiService
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        etUsername = findViewById(R.id.etusername)
        etPassword = findViewById(R.id.etpassword)
        etConfirmPassword = findViewById(R.id.etconfirmpassword)
        togglePassword = findViewById(R.id.ivTogglePassword)
        toggleConfirmPassword = findViewById(R.id.ivToggleConfirmPassword)
        btnSignIn = findViewById(R.id.btnSignIn)
        btnSignUpNow = findViewById(R.id.btnSignUpNow)

        this.btnSignIn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        this.btnSignUpNow.setOnClickListener{
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            registerUser(username, password, confirmPassword)
        }


        // SHOW/HIDE PASSWORD
        var isPasswordVisible = false
        this.togglePassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
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


        // SHOW/HIDE CONFIRM PASSWORD
        this.toggleConfirmPassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                // Show Password
                this.etConfirmPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                this.toggleConfirmPassword.setImageResource(R.drawable.ic_visibility_on) // Update to your "visible" icon
            } else {
                // Hide Password
                this.etConfirmPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                this.toggleConfirmPassword.setImageResource(R.drawable.ic_visibility_off) // Update to your "invisible" icon
            }
            // Move the cursor to the end of the text
            this.etConfirmPassword.setSelection(etConfirmPassword.text.length)
        }
    }

    private fun togglePasswordVisibility(isPasswordVisible: Boolean){
        etPassword = findViewById(R.id.etpassword)
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

    private fun registerUser(name: String, password: String, passwordConfirmation: String){
        val registerRequest = RegistrationRequest(name, password, passwordConfirmation)
        val call = apiService.registerUser(registerRequest)

        call.enqueue(object : retrofit2.Callback<RegistrationResponse> {
            override fun onResponse(call: retrofit2.Call<RegistrationResponse>, response: retrofit2.Response<RegistrationResponse>) {
                if (response.isSuccessful) {
                    val registrationResponse = response.body()
                    registrationResponse?.token?.let {
                        ApiLaravel.setAuthenticationToken(it)
                        Toast.makeText(
                            this@SignupActivity,
                            "Registration successful!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(this@SignupActivity, "Registration failed", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                Toast.makeText(this@SignupActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
