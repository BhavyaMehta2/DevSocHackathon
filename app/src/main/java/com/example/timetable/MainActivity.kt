package com.example.timetable

import CustomAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.ItemsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<ItemsViewModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userRecyclerview = findViewById(R.id.recyclerview)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<ItemsViewModel>()
        getUserData()

        val TimeTable=timetable()
        val Announcements=announcements()
        val Remainders=remainders()
        val Contacts = contacts()

        setCurrentFragment(TimeTable)
        var BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        BottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.timetable->setCurrentFragment(TimeTable)
                R.id.announcements->setCurrentFragment(Announcements)
                R.id.remainders->setCurrentFragment(Remainders)
                R.id.contacts->setCurrentFragment(Contacts)
            }
            true
        }
    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().reference.child("14Vft5tH5ToMI5w4mZedUvGlxmseDgZeskF8ktcmLoM8").child("Announcements")


        dbref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){


                        val user = userSnapshot.getValue(ItemsViewModel::class.java)
                        userArrayList.add(user!!)



                    }

                    userRecyclerview.adapter = CustomAdapter(userArrayList)


                }



            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }



    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,fragment)
            commit()
        }

    fun NewEventAction(view: View) {}
}