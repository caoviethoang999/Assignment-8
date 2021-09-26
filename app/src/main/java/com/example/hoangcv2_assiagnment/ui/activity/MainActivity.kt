package com.example.hoangcv2_assiagnment.ui.activity

import android.os.Bundle
import com.example.hoangcv2_assiagnment.R
import com.example.hoangcv2_assiagnment.databinding.ActivityMainBinding
import com.example.hoangcv2_assiagnment.ui.fragment.TitleFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerFragment = TitleFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, recyclerFragment)
            .commit()
    }
}