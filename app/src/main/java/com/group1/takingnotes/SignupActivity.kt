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
    private lateinit var togglePassword: ImageView
    private lateinit var toggleConfirmPassword: ImageView
    private lateinit var btnLoginNow: Button
    private lateinit var btnSignIn: Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        etUsername = findViewById(R.id.etusername)
        etPassword = findViewById(R.id.etpassword)
        etConfirmPassword = findViewById(R.id.etconfirmpassword)
        togglePassword = findViewById(R.id.ivTogglePassword)
        toggleConfirmPassword = findViewById(R.id.ivToggleConfirmPassword)
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
}