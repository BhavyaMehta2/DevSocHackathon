package com.example.timetable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,fragment)
            commit()
        }

    fun NewEventAction(view: View) {}
}

