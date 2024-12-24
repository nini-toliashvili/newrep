package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FilterRecyclerBinding

class FilterAdapter(private val filters: List<RecyclerFilter>) :
RecyclerView.Adapter<FilterAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            FilterRecyclerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBindFilter()
    }

    override fun getItemCount(): Int {
        return filters.size
    }


    inner class ItemViewHolder(val binding: FilterRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBindFilter() {
            val model: RecyclerFilter = filters[adapterPosition]
            binding.filterButton.setText(model.buttonText)

//            binding.filterButton.setOnClickListener {
//                if(binding.filterButton.isSelected) binding.filterButton.setBackgroundResource(R.drawable.filter_button_selected)
//                filterItems(binding.filterButton.text.toString())
//
//
//
//                var temp = mutableListOf<RecyclerItem>()
//
//                if (binding.filterButton.text.toString() != "All") {
//                    for (i in items) {
//                        if (i.category == binding.filterButton.text.toString()) temp.add(i)
//                    }
//                    changeItems(temp)
//                }
//            }
//
//        fun callFilterItem(string:String) {
//
//        }
        }
    }

}


