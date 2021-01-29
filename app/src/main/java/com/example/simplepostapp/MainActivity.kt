package com.example.simplepostapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView : BottomNavigationView
    //lateinit var container : FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.container_main, Fragment1()).commit()

        bottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.writeMemo -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container_main, Fragment1()).commit()
                    true
                }
                R.id.memos -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container_main, Fragment2()).commit()
                    true
                }
                R.id.setting -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container_main, Fragment3()).commit()
                    true
                }
                else -> false
            }
        }


    }
}