package com.example.recyclerviewkucing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val nama : TextView = findViewById(R.id.tv_nama_kucing)
        val photo : ImageView = findViewById(R.id.img_kucing)
        val detail : TextView = findViewById(R.id.tv_detail_kucing)

        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getIntExtra(EXTRA_PHOTO,0)
        val tIDetail = intent.getStringExtra(EXTRA_DETAIL)

        nama.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(photo)
        detail.text = tIDetail


    }
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DETAIL = "extra_detail"
    }
}
