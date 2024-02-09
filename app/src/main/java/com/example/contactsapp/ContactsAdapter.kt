package com.example.contactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(private val contactList:List<Contact>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTv :TextView = itemView.findViewById(R.id.name)
        val numberTv:TextView =itemView.findViewById(R.id.number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return contactList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contactList[position]
        holder.nameTv.text = contact.name
        holder.numberTv.text = contact.phone

        holder.itemView.setOnClickListener {
            listner?.onClick(contact)
        }

    }


    interface ItemOnClick {
        fun onClick(contact: Contact)
    }

    var listner :ItemOnClick? = null
}