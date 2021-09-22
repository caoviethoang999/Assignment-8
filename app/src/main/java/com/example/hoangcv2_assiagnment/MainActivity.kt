package com.example.hoangcv2_assiagnment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.hoangcv2_assiagnment.fragment.TitleFragment

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recylerFragment = TitleFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, recylerFragment)
            .commit()
    }
}