package com.group1.takingnotes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
                val signup = findViewById<Button>(R.id.btnSignup)
                val username = findViewById<EditText>(R.id.etusername)
                val password = findViewById<EditText>(R.id.etpassword)
                val forgot = findViewById<Button>(R.id.btnforgot)
                val loginnow = findViewById<Button>(R.id.btnloginnow)
                val signupnow = findViewById<Button>(R.id.btnSignupnow)


                // LOGIN
                loginnow.setOnClickListener {
                    val usernamee = username.text.toString()
                    val passwordd = password.text.toString()
                    if (usernamee == "") {
                        Toast.makeText(
                            this@MainActivity,
                            "Please Enter your Username",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (passwordd == "") {
                        Toast.makeText(
                            this@MainActivity,
                            "Please Enter your password",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this@MainActivity, "You Log in Successfully", Toast.LENGTH_SHORT
                        ).show()

                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)


                    }
                }
            }
        }