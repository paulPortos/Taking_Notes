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

class SignupActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnLoginNow: Button
    private lateinit var btnSignIn: Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        etUsername = findViewById(R.id.etusername)
        etPassword = findViewById(R.id.Password)
        etConfirmPassword = findViewById(R.id.confirmedpasss)
        btnLoginNow = findViewById(R.id.btnloginnow)
        btnSignIn = findViewById(R.id.btnSignIn)


        this.btnLoginNow.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val confirmpassword = etConfirmPassword.text.toString()
            if (username == "") { // Empty Input
                Toast.makeText(this@SignupActivity, "Please Enter your Username", Toast.LENGTH_SHORT).show()
            } else if (password == "") //Empty Input

            { Toast.makeText(this@SignupActivity, "Please Enter your Password", Toast.LENGTH_SHORT).show()

            }
            else if (confirmpassword == "") //Empty Input
            { Toast.makeText(this@SignupActivity, "Please Enter your Confirm Password", Toast.LENGTH_SHORT).show()

            }
            else if (password == confirmpassword)
            { Toast.makeText(this@SignupActivity, "Account has been successfully created", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,SignupActivity::class.java)
                startActivity(intent)

            }
            else
            { Toast.makeText(this@SignupActivity, "Confirm Password is not match to Password", Toast.LENGTH_SHORT).show()
            }

        }

        this.btnSignIn.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }



    }
}