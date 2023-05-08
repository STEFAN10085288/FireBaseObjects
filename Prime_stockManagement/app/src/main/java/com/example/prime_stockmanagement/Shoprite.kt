package com.example.prime_stockmanagement

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*
import kotlin.collections.ArrayList

class Shoprite:IShop {

    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("ShopriteStockList")
    private lateinit var stockArrayList : ArrayList<StockData>

    override fun AddStock(Number: Int, Barcode: String, Name: String, Price: String, QTY: String): Int {
        val stockData = StockData(Barcode,Name,Price,QTY);
        myRef.child("Item $Number").setValue(stockData)
        return 0;
    }

    override fun DeleteStock(Number: Int): Int {
        myRef.child("Item $Number").removeValue()
        return 0;
    }

    override fun UpdateStock(Number: Int, Barcode: String, Name: String, Price: String, QTY: String): Int {
        val stock = mapOf<String,String>(
            "StockBarCode" to Barcode,
            "StockName" to Name,
            "StockPrice" to Price.toString(),
            "StockQTY" to QTY.toString()
        )
        myRef.child("Item $Number").updateChildren(stock)
        return 0;
    }

    override fun GetStock(stockRecyclerView: RecyclerView, stockRecyclerViewlayoutManager: LinearLayoutManager, stockRecyclerViewSetHasFixedSize: Boolean): Int {
        stockArrayList  = arrayListOf<StockData>()

        myRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (stockSnapshot in snapshot.children) {
                        val stock = stockSnapshot.getValue(StockData::class.java)
                        stockArrayList.add(stock!!)
                        Log.i("stock list", stockArrayList.size.toString())
                    }
                    stockRecyclerView.adapter = StockAdapter(stockArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        return 0
    }
}