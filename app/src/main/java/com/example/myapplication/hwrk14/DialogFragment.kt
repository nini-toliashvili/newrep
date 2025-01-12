package com.example.myapplication.hwrk14

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.myapplication.databinding.DialogLayoutBinding

class DialogFragment: DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            val name = it?.getString("name")
            val image = it?.getInt("image")
            val quantity = it?.getInt("quantity")
            val colorHex = it?.getInt("colorHex")
            val price = it?.getFloat("price")
            val colorName = it?.getString("colorName")

        }

    }
   private var _binding: DialogLayoutBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }


    companion object {
        fun newInstance(itemName: String, image: Int, quantity:Int, colorHex:Int, price: Float, colorName: String) =
            com.example.myapplication.hwrk14.DialogFragment().apply {
                arguments = Bundle().apply {
                    putString("name", itemName)
                    putInt("image", image)
                    putInt("quantity", quantity)
                    putInt("colorHex", colorHex)
                    putFloat("price", price)
                    putString("colorName", colorName)
                }
            }
    }
}