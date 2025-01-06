package com.example.myapplication.hwrk13

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentChatBinding
import java.util.Date
import java.util.Locale

class FragmentChat: Fragment() {

    private var _binding : FragmentChatBinding? = null
    private val binding get() = _binding!!
    @RequiresApi(Build.VERSION_CODES.O)
    val messages = mutableListOf<message>(
        message("Hello, can I help you?", true, "Today, ${getCurrentTime()}")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpFragment()

    }








    @RequiresApi(Build.VERSION_CODES.O)
    private fun setUpFragment() {
        val adapter = MessageAdapter(messages)
        binding.displayedMessages.layoutManager = LinearLayoutManager(this.requireContext())
        binding.displayedMessages.adapter = adapter
        adapter.submitList(messages.toList())

        binding.sendButton.setOnClickListener {
            val messageInfield = binding.messageField.text.toString()
            if (messageInfield != "") {
                if (messages.size %2 == 0) messages.add( message(messageInfield, true, "Today, ${getCurrentTime()}"))
                else messages.add(message(messageInfield, false, "Today, ${getCurrentTime()}"))

                binding.messageField.setText("")
                adapter.submitList(messages.toList())
            }
        }


    }




    private fun getCurrentTime(): String {
        return SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())
    }

}