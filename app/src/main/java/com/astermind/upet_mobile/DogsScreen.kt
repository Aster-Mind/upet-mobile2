package com.astermind.upet_mobile

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DogsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dogs_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        val cBotonAdoptar = findViewById<FloatingActionButton>(R.id.gBotonAdoptar)
        cBotonAdoptar.setOnClickListener(){
            try {
                val i = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Hola ")
                    putExtra("jid", "${{}}@s.whatsapp.net")
                    type = "text/plain"
                    setPackage("com.whatsapp")
                }
                startActivity(i)
            } catch (e: Exception) {
                e.printStackTrace()
                val appPackageName = "com.whatsapp"
                try {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=$appPackageName")
                        )
                    )
                }catch (e: android.content.ActivityNotFoundException){
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
                }
            }
        }
    }
}