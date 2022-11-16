package com.astermind.upet_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.astermind.upet_mobile.databinding.ActivityUserScreenBinding

class UserScreen : AppCompatActivity() {

    private lateinit var binding: ActivityUserScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        binding.gAgregarMascota.setOnClickListener() {
            goToAdd()
        }
    }

    private fun goToAdd() {
        val i = Intent(this, AddScreen::class.java)
        startActivity(i)
    }
}
