package com.example.myapplication.shemajamebeli3

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.hwrk13.message

class DiffUtilCellState: DiffUtil.ItemCallback<CellState> () {
    override fun areItemsTheSame(oldItem: CellState, newItem: CellState): Boolean {
        return oldItem.isEmpty == newItem.isEmpty && oldItem.isX == newItem.isX
    }

    override fun areContentsTheSame(oldItem: CellState, newItem: CellState): Boolean {
        return oldItem==newItem
    }
}