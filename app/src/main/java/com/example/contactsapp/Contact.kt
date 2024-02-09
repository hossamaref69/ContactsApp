package com.example.contactsapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize

data class Contact  (val name:String, val phone:String, val discrubtion:String) :Parcelable
