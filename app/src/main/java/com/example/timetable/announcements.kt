package com.example.timetable

import CustomAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.ItemsViewModel
import com.google.firebase.database.*

private lateinit var dbref : DatabaseReference
private lateinit var userRecyclerview : RecyclerView
private lateinit var userArrayList : ArrayList<ItemsViewModel>

class announcements:Fragment(R.layout.fragment_announcements) {

}