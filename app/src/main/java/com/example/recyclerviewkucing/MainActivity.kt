package com.example.recyclerviewkucing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkucing.tentang.TentangActivity

class MainActivity : AppCompatActivity() {
    private lateinit var rvKucing : RecyclerView
    var list : ArrayList<Kucing> = arrayListOf()

    private var title: String = "Macam-macam Kucing"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvKucing = findViewById(R.id.rv_kucing)
        rvKucing.setHasFixedSize(true)

        list.addAll(DataKucing.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvKucing.layoutManager = LinearLayoutManager(this)
        val listKucingAdapter = ListKucingAdapter(list)
        rvKucing.adapter = listKucingAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.menu_profile -> {
                val iAbout = Intent(this@MainActivity,
                    TentangActivity::class.java)
                startActivity(iAbout)
            }
        }
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}