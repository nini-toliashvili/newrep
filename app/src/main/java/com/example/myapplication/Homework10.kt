package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.Homework10Binding




val filters = mutableListOf(
    RecyclerFilter( R.string.all),
    RecyclerFilter( R.string.camping),
    RecyclerFilter( R.string.partying),
    RecyclerFilter( R.string.boots),
    RecyclerFilter( R.string.jackets)
)


var itemsStored = mutableListOf(
    RecyclerItem(R.drawable.boots1, "Block heel boots", "$199", "Boots"),
    RecyclerItem(R.drawable.boots2, "Wide-leg high-heel boots", "$249", "Boots"),
    RecyclerItem(R.drawable.jacket, "Faux Shearling Jacket with Contrast Details", "$199", "Jackets"),
    RecyclerItem(R.drawable.boots3, "Sock-style platform ankle boots", "$159", "Boots"),
    RecyclerItem(R.drawable.jacketcamping, "Bonded fleece jacket", "$70", "Camping"),
    RecyclerItem(R.drawable.blazer, "Oversize satin blazer", "$159", "Jackets"),
    RecyclerItem(R.drawable.tent, "Camping Tent Weatherproof", "$79.04", "Camping"),
    RecyclerItem(R.drawable.hbd_partying, "Happy Birthday Balloons", "$8", "Partying")
    )
var items = itemsStored
fun changeItems(newList:  MutableList<RecyclerItem>) {

    items = newList
}



//fun filterItems(selectedFilter: String) : MutableList<RecyclerItem> {
//
//    return if (selectedFilter == "All") itemsStored
//    else {
//        items.filter { it.category == selectedFilter }.toMutableList()
//
//    }
//}

class Homework10: AppCompatActivity() {
    private lateinit var binding: Homework10Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Homework10Binding.inflate(layoutInflater)
        setContentView(binding.root)



        val adapter = ItemAdapter(items)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter

        val adapter2 = FilterAdapter(filters)
        binding.recyclerViewFilters.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewFilters.adapter = adapter2





    }






}