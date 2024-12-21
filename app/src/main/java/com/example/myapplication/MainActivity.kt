package com.example.myapplication
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUp()
    }






    private fun setUp() {
        val text = "Don't have an account? Sign up"
        val spannableString = SpannableString(text)
        spannableString.setSpan(ForegroundColorSpan(Color.BLACK), 23, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(object : ClickableSpan(){
            override fun onClick(widget: View) {
                binding.signin.visibility = View.GONE
                binding.signUp.visibility = View.VISIBLE

            }
    }, 23, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.text.text = spannableString
        binding.text.movementMethod = LinkMovementMethod.getInstance()










        val textSignin = "Already have an account? Sign in"
        val spannable = SpannableString(textSignin)
        spannable.setSpan(ForegroundColorSpan(Color.BLACK), 25, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(object : ClickableSpan(){
            override fun onClick(widget: View) {
                binding.signUp.visibility = View.GONE
                binding.signin.visibility = View.VISIBLE
            }
        }, 23, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.signintext.text = spannable
        binding.signintext.movementMethod = LinkMovementMethod.getInstance()

    }


}
