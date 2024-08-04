package com.example.takingnotess

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.takingnotess.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize binding first
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomAppBar.setOnClickListener { item ->
            when (item.id) {
                R.id.btnhome -> replaceFragment(Home())
                R.id.btntask -> replaceFragment(Task())
                R.id.btnflashcards -> replaceFragment(Setting())
                else -> {}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.coordinatorLayout, fragment)
        fragmentTransaction.commit()
    }
}
