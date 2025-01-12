package com.example.myapplication.hwrk14

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.hwrk13.message

class OrderDiffUtil: DiffUtil.ItemCallback<ListItems> () {
    override fun areItemsTheSame(oldItem: ListItems, newItem: ListItems): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ListItems, newItem: ListItems): Boolean {
        return oldItem == newItem
    }
}