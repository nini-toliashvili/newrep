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
import com.example.myapplication.databinding.Fragment2Binding

class Fragment2: Fragment() {

    private var _binding: Fragment2Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val textSignin = "Already have an account? Sign in"
        val spannable = SpannableString(textSignin)
        spannable.setSpan(ForegroundColorSpan(Color.BLACK), 25, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(object : ClickableSpan(){
            override fun onClick(widget: View) {
            val fragment1 = Fragment1()
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.main, fragment1).addToBackStack(null).commit()

            }
        }, 23, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.signintext.text = spannable
        binding.signintext.movementMethod = LinkMovementMethod.getInstance()


    }


}