package com.example.myapplication.shemajamebeli3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainSBinding

class ActivityMain : AppCompatActivity() {
    private lateinit var binding: ActivityMainSBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState==null) {
            binding = ActivityMainSBinding.inflate(layoutInflater)
            setContentView(binding.root)
            val fragment = FragmentForGrid()
            supportFragmentManager.beginTransaction()
                .add(binding.fragmentContainerS.id, fragment)
                .commit()
        }
    }
}