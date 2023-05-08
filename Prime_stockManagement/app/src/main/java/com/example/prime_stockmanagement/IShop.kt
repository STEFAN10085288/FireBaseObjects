package com.example.prime_stockmanagement

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Dictionary

interface IShop {

    fun AddStock(Number : Int, Barcode : String, Name: String, Price: String, QTY : String) : Int

    fun DeleteStock(Number : Int) : Int

    fun UpdateStock(Number : Int, Barcode : String, Name: String, Price: String, QTY : String) : Int

    fun GetStock(stockRecyclerView : RecyclerView, stockRecyclerViewlayoutManager : LinearLayoutManager, stockRecyclerViewSetHasFixedSize : Boolean) :Int



}