package com.example.myapplication

import android.os.Bundle
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.Homework11Binding
import org.w3c.dom.Text

class Homework11:AppCompatActivity() {
    private lateinit var binding: Homework11Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Homework11Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()

    }


    private fun setUp() {


        val adapter = LocationListAdapter()
        binding.recyclerViewL.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewL.adapter = adapter



    fun listeners() {

//        val addressContainer:TextView = findViewById(R.id.address_container)
//        val addressName: TextView = findViewById(R.id.address)
//        addressContainer.setOnLongClickListener {
//            val removable = locations.find { i -> i.getAddress() == addressName.text.toString()  }
//            locations.remove(removable)
//            adapter.submitList(locations.toList())
//        return@setOnLongClickListener true}

        binding.addAddressButton.setOnClickListener {
            binding.locations.visibility = View.GONE
            binding.addLocationContainer.visibility = View.VISIBLE
        }

        binding.saveLocationButton.setOnClickListener {
            id = id++
            if (binding.nameOfAddress.text.toString() == "") {
                binding.nameOfAddress.error = "field can not be empty"
            }
            if (binding.city.text.toString() == "") {
                binding.city.error = "field can not be empty"
            }
            if (binding.streetName.text.toString() == "") {
                binding.streetName.error = "field can not be empty"
            }
            if (binding.building.text.toString() == "") {
                binding.building.error = "field can not be empty"
            }
            val newLocation = LocationItem(
                id,
                binding.nameOfAddress.text.toString(),
                binding.city.text.toString(),
                binding.streetName.text.toString(),
                binding.building.text.toString()
            )

            locations.add(newLocation)
            binding.locations.visibility = View.VISIBLE
            binding.addLocationContainer.visibility = View.GONE


            binding.nameOfAddress.setText("")
            binding.city.setText("")
            binding.streetName.setText("")
            binding.building.setText("")


            adapter.submitList(locations.toList())

        }

//        val edit: TextView = findViewById(R.id.edit_location)
//
//        edit.setOnClickListener {
//
//
//            val editable = locations.find {i -> i.getAddress() == addressName.text.toString() }
//            if (editable != null) {
//                binding.locations.visibility = View.GONE
//                binding.addLocationContainer.visibility = View.VISIBLE
//
//
//            }
//        }

    }

        listeners()

}
}



val locations = mutableListOf<LocationItem>(
    LocationItem(1,"Home", "Gori", "Bako", "10/33"),
    LocationItem(2,"Home", "Gori", "Bako", "10/33"),
    LocationItem(3,"Home", "Gori", "Bako", "10/33")
)
var id: Int = 0