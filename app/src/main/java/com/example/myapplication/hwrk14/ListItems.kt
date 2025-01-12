package com.example.myapplication.hwrk14

import java.util.UUID

sealed class ListItems {
    data class ActiveOrder(val id:UUID, val name:String, val colorHex:String, val colorName:String, val quantity:Int, val price:Float, val status:String = "Active" , val img:Int):ListItems(){


        override fun equals(other: Any?): Boolean {
            return super.equals(other)
        }
    }

    data class CompletedOrder(val id:UUID, val name:String, val colorHex:String, val colorName:String, val quantity:Int, val price:Float, val status:String = "Completed", val img:Int):ListItems() {
        override fun equals(other: Any?): Boolean {
            return super.equals(other)
        }
    }
}