package com.example.myapplication.hwrk13

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.Homework13Binding

class Homework13 : AppCompatActivity() {
    private lateinit var binding : Homework13Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState==null) {
        binding = Homework13Binding.inflate(layoutInflater)
            setContentView(binding.root)
            val fragment = FragmentChat()
            supportFragmentManager.beginTransaction()
                .add(binding.fragmentContainer.id, fragment)
                .commit()
        }
    }
}