package com.example.myapplication

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.Fragment1Binding

class Fragment1: Fragment() {
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)


        val text = "Don't have an account? Sign up"
        val spannableString = SpannableString(text)
        spannableString.setSpan(ForegroundColorSpan(Color.BLACK), 23, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(object : ClickableSpan(){
            override fun onClick(widget: View) {
                val fragment2 = Fragment2()
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.main, fragment2).addToBackStack(null).commit()
            }
        }, 23, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.text.text = spannableString
        binding.text.movementMethod = LinkMovementMethod.getInstance()
    }
}