package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.SavedLocationBinding

class LocationListAdapter : ListAdapter<LocationItem, LocationListAdapter.LocViewHolder>(ItemDiffCallback()){

     class LocViewHolder(private val binding: SavedLocationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LocationItem) {
        binding.adddressName.text = item.nameOfAddress
            binding.address.text = item.getAddress()
        }

        companion object{
            fun from(parent: ViewGroup): LocViewHolder {
                val binding = SavedLocationBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
                return LocViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocViewHolder {
        return LocViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LocViewHolder, position: Int) {
        holder.bind(getItem(position))

    }


}