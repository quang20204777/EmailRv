package com.example.emailrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailList = mutableListOf<Email>()
        emailList.add(Email("Doremon", "sdfajsfjkasdf", "avatar11", "11:00 AM", true))
        emailList.add(Email("Nobita", "afsdfasdfja", "avatar12", "12:20 AM", false))
        emailList.add(Email("Xuka", "áfdfdfd", "avatar13", "Yesterday", true))
        emailList.add(Email("Chaien", "sadfkadkfjaldskf", "avatar14", "2h ago", false))
        emailList.add(Email("Naruto", "fkasjfkasjka", "avatar7", "11:45 AM", false))
        emailList.add(Email("Kakashi", "Nsdfsfs", "avatar8", "12:30 PM", true))
        emailList.add(Email("Mganga", "Weekend", "avatar9", "Yesterday", false))
        emailList.add(Email("Lukaku", "sakfjsdf", "avatar10", "1 days ago", true))
        emailList.add(Email("Jax", "sdfkfjsfs", "avatar3", "10:15 AM", true))
        emailList.add(Email("Moriganna", "oeriwoiutrtq", "avatar4", "Yesterday", false))
        emailList.add(Email("Dog", "eioqruwirwerew", "avatar5", "2 days ago", false))
        emailList.add(Email("Gaoohhhh", "weqrwpeoripo", "avatar6", "Last week", true))

        val emailAdapter = EmailAdapter(emailList)

        val recyclerView: RecyclerView = findViewById(R.id.recycleView)
        recyclerView.adapter = emailAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

    }
}