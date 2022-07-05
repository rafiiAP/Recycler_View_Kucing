package com.example.recyclerviewkucing.tentang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.recyclerviewkucing.R

class TentangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang)
        val actionbar = supportActionBar
        actionbar!!.title = "Profile"
        actionbar.setDisplayHomeAsUpEnabled(true)

        findViewById<ImageView>(R.id.img_item_photo)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}