package com.example.firebaseobjects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var  rootNode: FirebaseDatabase
    private lateinit var userRef : DatabaseReference
    private lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lstOutput)
        rootNode = FirebaseDatabase.getInstance()
        userRef = rootNode.getReference("Users")

        val dc = DataClass("Y tapes", "Yellow tape",82,800)
        userRef.child(dc.id.toString()).setValue(dc)

        val list = ArrayList<String>()
        val adapter = ArrayAdapter<String>(this,R.layout.list_items,list)
        listView.adapter = adapter

        userRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                for (snapshot1 in snapshot.children){
                    val dc2 = snapshot.getValue(DataClass::class.java)
                    val txt = "${dc2?.name} ${dc2?.description}"
                    txt?.let { list.add(it) }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }
}