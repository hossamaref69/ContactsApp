package com.example.contactsapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import com.example.contactsapp.databinding.ActivityContactDetailsBinding
import com.example.contactsapp.databinding.ActivityMainBinding

class ContactDetailsActivity: AppCompatActivity() {
    lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val contact = IntentCompat.getParcelableExtra(intent,Constants.CONTACT,Contact::class.java)

        contact?.let {contact ->
            binding.mainName.text = contact.name
            binding.nameValue.text = contact.name
            binding.numberValue.text = contact.phone
            binding.discrubtionValue.text = contact.discrubtion
        }
    }

}