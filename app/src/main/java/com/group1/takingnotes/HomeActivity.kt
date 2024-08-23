package com.group1.takingnotes

import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.group1.takingnotes.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val fromBottomFabAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.from_bottom_fab)
    }
    private val toBottomFabAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.to_bottom_fab)
    }
    private val rotateClockWiseFabAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.rotate_clock_wise)
    }
    private val rotateAntiClockWiseFabAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.rotate_anti_clock_wise)
    }
    private val fromBottomBgAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim)
    }
    private val toBottomBgAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim)
    }

    private var areFabButtonsVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        // Initialize binding first
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(Home()) // PARA MAG DIRECT AGAD SA HOME

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.btnhome -> replaceFragment(Home())
                R.id.btntask -> replaceFragment(Task())
                R.id.btnflashcards -> replaceFragment(Flashcard())
                else -> {}
            }
            true
        }




        binding.mainFabBtn.setOnClickListener {

            if (areFabButtonsVisible) {
                shrinkFab()
            } else {
                expandFab()
            }

        }

    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }


    private fun shrinkFab() {

        binding.mainFabBtn.startAnimation(rotateAntiClockWiseFabAnim)
        binding.notesFabBtn.startAnimation(toBottomFabAnim)
        binding.flashcardsFabBtn.startAnimation(toBottomFabAnim)
        binding.notesTV.startAnimation(toBottomFabAnim)
        binding.flashcardsTV.startAnimation(toBottomFabAnim)




        areFabButtonsVisible = !areFabButtonsVisible
    }

    private fun expandFab() {
        binding.mainFabBtn.startAnimation(rotateClockWiseFabAnim)
        binding.notesFabBtn.startAnimation(fromBottomFabAnim)
        binding.flashcardsFabBtn.startAnimation(fromBottomFabAnim)
        binding.notesTV.startAnimation(fromBottomFabAnim)
        binding.flashcardsTV.startAnimation(fromBottomFabAnim)
        areFabButtonsVisible = !areFabButtonsVisible
    }

    override fun onBackPressed() {
        if (areFabButtonsVisible) {
            shrinkFab()
        } else {
            super.onBackPressed()
        }
    }

}