package com.group1.takingnotes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnSignup: Button
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnForgot: Button
    private lateinit var btnLoginNow: Button
    private lateinit var togglePassword: ImageView

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

        // LOGIN
        this.btnLoginNow.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            if (username == "") { // Empty Input
                Toast.makeText(this@MainActivity, "Please Enter your Username", Toast.LENGTH_SHORT).show()
            } else if (password == "") //Empty Input
            { Toast.makeText(this@MainActivity, "Please Enter your Password", Toast.LENGTH_SHORT).show()
            }
            else
            { Toast.makeText(this@MainActivity, "You Log in Successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
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

        // SIGN UP
        this.btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}