package com.example.prime_stockmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


class ViewDetails_activity : AppCompatActivity() {

    private lateinit var stockRecyclerView : RecyclerView
    private lateinit var stockArrayList : ArrayList<StockData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_details)

        stockRecyclerView = findViewById(R.id.ViewDetails)
        val stockRecyclerViewlayoutManager = LinearLayoutManager(this).also { this.stockRecyclerView.layoutManager = it }
        stockRecyclerView.setHasFixedSize(true)

        val viewShopName = intent.getStringExtra("shopName")

        stockArrayList = arrayListOf<StockData>()

        val factory = ShopFactory()

        if (viewShopName =="checkers")
        {
            var shop = factory.makeShop(ShopType.Checkers)
            shop?.GetStock(stockRecyclerView, stockRecyclerViewlayoutManager,true )!!
        }else if (viewShopName =="shoprite")
        {
            var shop = factory.makeShop(ShopType.Shoprite)
            shop?.GetStock(stockRecyclerView, stockRecyclerViewlayoutManager,true )!!
        }

    }
}