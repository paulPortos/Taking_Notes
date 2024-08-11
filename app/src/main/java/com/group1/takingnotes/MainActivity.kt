package com.group1.takingnotes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnSignup: Button
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnForgot: Button
    private lateinit var btnLoginNow: Button
    private lateinit var btnSignupNow: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSignup = findViewById(R.id.btnSignUp)
        etUsername = findViewById(R.id.etusername)
        etPassword = findViewById(R.id.etpassword)
        btnForgot = findViewById(R.id.btnforgot)
        btnLoginNow = findViewById(R.id.btnloginnow)

        // LOGIN
        btnLoginNow.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            if (username == "") {
                Toast.makeText(this@MainActivity, "Please Enter your Username", Toast.LENGTH_SHORT).show()
            } else if (password == "") { Toast.makeText(this@MainActivity, "Please Enter your password", Toast.LENGTH_SHORT).show()
            } else { Toast.makeText(this@MainActivity, "You Log in Successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
        btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}