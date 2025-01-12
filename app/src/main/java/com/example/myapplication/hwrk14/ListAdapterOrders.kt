package com.example.myapplication.hwrk14

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemForOrdersBinding

class ListAdapterOrders(private val listOfOrders: List<ListItems>): ListAdapter<ListItems, RecyclerView.ViewHolder>(OrderDiffUtil()) {

    private var onItemClick: ((ListItems.CompletedOrder) -> Unit)? = null
    constructor(listOfOrders: List<ListItems>, onItemClick: (ListItems.CompletedOrder) -> Unit) : this(listOfOrders) {
        this.onItemClick = onItemClick
    }

    companion object{
       const val IS_ACTIVE = 0
       const val IS_COMPLETED = 1
   }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position) is ListItems.ActiveOrder) IS_ACTIVE
        else IS_COMPLETED
    }

    inner class ActiveOrderViewHolder( val binding: ItemForOrdersBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun onBind(item: ListItems.ActiveOrder) {
                binding.completedButton.text = item.status
                binding.orderImage.setImageResource(item.img)
                binding.quantity.setText("Qty = " + item.quantity)
                binding.orderedItemName.text = item.name
                binding.colorIndicator.setBackgroundColor(item.colorHex.toColorInt())
                binding.priceOfItem.text = "$${item.price}0"
                binding.colorOfItem.text = "${item.colorName}  |  "
            }

    }


    inner class CompletedOrderViewHolder(private val binding: ItemForOrdersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ListItems.CompletedOrder) {
            binding.completedButton.text = item.status
            binding.orderImage.setImageResource(item.img)
            binding.quantity.setText("Qty = " + item.quantity)
            binding.orderedItemName.text = item.name
            binding.colorIndicator.setBackgroundColor(item.colorHex.toColorInt())
            binding.priceOfItem.text = "$${item.price}0"
            binding.colorOfItem.text = "${item.colorName}  |  "

            binding.completedButton.setOnClickListener {
                onItemClick?.invoke(item)
            }
        }

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  if (viewType == IS_ACTIVE) ActiveOrderViewHolder(
           ItemForOrdersBinding.inflate(
               LayoutInflater.from(parent.context),
               parent,
               false)
        )  else CompletedOrderViewHolder(
            ItemForOrdersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = listOfOrders[position]
        if(holder is ActiveOrderViewHolder) {
            holder.onBind(currentItem as ListItems.ActiveOrder)
        } else if (holder is CompletedOrderViewHolder) holder.onBind(currentItem as ListItems.CompletedOrder)
    }
}