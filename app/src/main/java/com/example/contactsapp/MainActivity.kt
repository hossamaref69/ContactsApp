package com.example.contactsapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var name : String
    lateinit var phone : String
    lateinit var discrubtion : String
    lateinit var adapter: ContactsAdapter
    val contactList = mutableListOf<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecycleView()
        onSaveBtnClick()

    }

    private fun initRecycleView(){
        adapter = ContactsAdapter(contactList)
        binding.recyclerView.adapter = adapter

        adapter.listner = object : ContactsAdapter.ItemOnClick {
            override fun onClick(contact: Contact) {
                val intent = Intent(this@MainActivity,ContactDetailsActivity::class.java)
                intent.putExtra(Constants.CONTACT,contact)
                startActivity(intent)
            }
        }
    }

    private fun onSaveBtnClick() {
        binding.savedBt.setOnClickListener {
            if (!validaTextFields()) {
                return@setOnClickListener
            }
            name = binding.nameEdt.text?.trim().toString()
            phone = binding.phoneEdt.text?.trim().toString()
            discrubtion = binding.discrubtionEdt.text?.trim().toString()
            val contact = Contact(name, phone, discrubtion)
            contactList.add(contact)
            adapter.notifyItemInserted(contactList.size-1)
        }
    }

    private fun validaTextFields():Boolean{
        name = binding.nameEdt.text?.trim().toString()
        phone = binding.phoneEdt.text?.trim().toString()
        binding.nameTil.error = validaName(name)
        binding.phoneTil.error = validaPhone(phone)
        return (validaName(name) == null && validaPhone(phone) == null ) //true
    }

    private fun validaName(name:String):String?{
        if (name.isEmpty())
            return "Required"
        if (name.trim().length<3)
            return "Name cant be less than 3 characters"
        return null
    }

    private fun validaPhone(numbers:String):String?{
        if (numbers.isEmpty())
            return "Required"
        if (numbers.trim().length<11)
            return "numbers cant be less than 11 digits"
        return null
    }

}