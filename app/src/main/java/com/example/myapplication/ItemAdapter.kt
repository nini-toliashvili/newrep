package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemRecyclerviewBinding

class ItemAdapter(private val items: List<RecyclerItem>) :
RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.onBind()
    }

    fun updateData(newItems: MutableList<RecyclerItem>) {
        changeItems(newItems)
    }

    inner class ItemViewHolder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun onBind() {
                val model: RecyclerItem = items[adapterPosition]
                binding.imageItem.setImageResource(model.imageRes)
                binding.itemNameTv.text = model.tv_name
                binding.itemCost.text = model.tv_cost

            }
        }
}

