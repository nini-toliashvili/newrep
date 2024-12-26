package com.example.myapplication

class LocationItem (
    val id:Int,
    val nameOfAddress: String,
    val city:String,
    val streetName:String,
    val building:String
){


   fun getAddress():String {
       return "${this.building}, ${this.streetName}, ${this.city}"
   }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}