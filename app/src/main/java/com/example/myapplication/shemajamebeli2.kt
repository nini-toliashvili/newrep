package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.Shemajamebeli2Binding

class shemajamebeli2: AppCompatActivity() {
    private val listOfUsers = mutableListOf<user>()
    private var count = 1
    private lateinit var binding: Shemajamebeli2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Shemajamebeli2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()

    }



    private fun setUp() {


listeners()

    }

    private fun listeners() {
//

        binding.gotoAddUser.setOnClickListener {
            binding.search.visibility = View.GONE
            binding.add.visibility = View.VISIBLE
        }



        binding.addUser.setOnClickListener {

            binding.add.visibility = View.GONE
            binding.search.visibility = View.VISIBLE
            if (binding.firstName.text.toString() =="") binding.firstName.error = "field can not be empty"
            if (binding.lastName.text.toString() =="") binding.lastName.error = "field can not be empty"
            if (binding.dateOfBirth.text.toString() =="") binding.dateOfBirth.error = "field can not be empty"
            if (binding.email.text.toString() =="") binding.email.error = "field can not be empty"
            if (binding.address.text.toString() =="") binding.address.error = "field can not be empty"


            addUser()
            binding.firstName.setText("")
            binding.lastName.setText("")
            binding.dateOfBirth.setText("")
            binding.email.setText("")
            binding.address.setText("")

        }


        binding.searchUser.setOnClickListener {
        search()
        }




    }


    private fun addUser() {
        var validNewUser = true
        val firstname = binding.firstName.text.toString()
        val lastname = binding.lastName.text.toString()
        val dateOfBirth = binding.dateOfBirth.text.toString().toInt()
        val email = binding.email.text.toString()
        val address = binding.address.text.toString()
        val newUser  = user(count++,firstname, lastname, dateOfBirth, address, email)
        for (i in listOfUsers) {
            if (i.email == newUser.email) validNewUser = false
        }

        if (validNewUser) listOfUsers.add(newUser)
    }


private fun search() {
    var userFound = false
    var foundUser:user? = null
    val firstname = binding.firstNames.text.toString()
    val lastname = binding.lastNames.text.toString()
    val email = binding.emailS.text.toString()
    val dateOfBirth = binding.dateOfBirthS.text.toString()
    val address = binding.addressS.text.toString()
    if(firstname.isNotEmpty()|| lastname.isNotEmpty() || email.isNotEmpty() || dateOfBirth.isNotEmpty() || address.isNotEmpty()) {
        for (i in listOfUsers) {
            if (i.toString().contains(firstname)) {
                userFound = true
                foundUser = i
                break
            }

            if (i.toString().contains(lastname)) {
                userFound = true
                foundUser = i
                break
            }

            if (i.toString().contains(email)) {
                userFound = true
                foundUser = i
                break
            }

            if (i.toString().contains(dateOfBirth)) {
                userFound = true
                foundUser = i
                break
            }

            if (i.toString().contains(address)) {
                userFound = true
                foundUser = i
                break
            }
        }

        if (userFound) {
            binding.searchShowUser.setText(foundUser!!.id)
            binding.gotoAddUser.visibility = View.INVISIBLE
            binding.firstNames.setText("")
            binding.lastNames.setText("")
            binding.dateOfBirthS.setText("")
            binding.addressS.setText("")
            binding.emailS.setText("")
        } else {
            binding.gotoAddUser.visibility = View.VISIBLE
            binding.searchShowUser.setText("User not found")
        }
    }
}
}