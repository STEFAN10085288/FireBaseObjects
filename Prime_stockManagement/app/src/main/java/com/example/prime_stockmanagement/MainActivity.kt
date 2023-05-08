package com.example.prime_stockmanagement

import android.content.Intent
import android.icu.text.Transliterator.Position
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {
    var shopname : String = ""
    var viewShopname : String= ""
    var stockNumber : Int = 0
    var stockBarCode : String = ""
    var stockName : String = ""
    var stockPrice : String = ""
    var stockQTY : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val shops = resources.getStringArray(R.array.Shops)
        val spinner1 = findViewById<Spinner>(R.id.cbShop)
        if(spinner1 != null)
        {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, shops)
            spinner1.adapter = adapter
        }

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long){
                 shopname = shops[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


        val spinner2 = findViewById<Spinner>(R.id.cbViewShopDetails)
        if(spinner2 != null)
        {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, shops)
            spinner2.adapter = adapter
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long){
                viewShopname = shops[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val txtStockNumber : EditText = findViewById(R.id.StockNumber)
        val txtStockBarcode : EditText = findViewById(R.id.StockBarCode)
        val txtStockName : EditText = findViewById(R.id.StockName)
        val txtStockPrice : EditText = findViewById(R.id.StockPrice)
        val txtStockQTY : EditText = findViewById(R.id.StockQTY)

        val btnInsert : Button = findViewById(R.id.btnInsert)
        val btnUpdate : Button = findViewById(R.id.btnUpdate)
        val btnViewDetails : Button = findViewById(R.id.btnViewDetails)
        val btnDelete : Button = findViewById(R.id.btnDelete)

        btnInsert.setOnClickListener()
        {
            stockNumber = parseInt(txtStockNumber.text.toString())
            stockBarCode = txtStockBarcode.text.toString()
            stockName = txtStockName.text.toString()
            stockPrice = txtStockPrice.text.toString()
            stockQTY = txtStockQTY.text.toString()

            val factory = ShopFactory()

            if (shopname.lowercase()=="checkers")
            {
                var shop = factory.makeShop(ShopType.Checkers)
                var result = shop?.AddStock(stockNumber,stockBarCode,stockName,stockPrice,stockQTY)
            }else if (shopname.lowercase()=="shoprite")
            {
                var shop = factory.makeShop(ShopType.Shoprite)
                var result = shop?.AddStock(stockNumber,stockBarCode,stockName,stockPrice,stockQTY)
            }


        }

        btnUpdate.setOnClickListener()
        {
            stockNumber = parseInt(txtStockNumber.text.toString())
            stockBarCode = txtStockBarcode.text.toString()
            stockName = txtStockName.text.toString()
            stockPrice = txtStockPrice.text.toString()
            stockQTY = txtStockQTY.text.toString()

            val factory = ShopFactory()

            if (shopname.lowercase()=="checkers")
            {
                var shop = factory.makeShop(ShopType.Checkers)
                var result = shop?.UpdateStock(stockNumber,stockBarCode,stockName,stockPrice,stockQTY)
            }else if (shopname.lowercase()=="shoprite")
            {
                var shop = factory.makeShop(ShopType.Shoprite)
                var result = shop?.UpdateStock(stockNumber,stockBarCode,stockName,stockPrice,stockQTY)
            }
        }

        btnViewDetails.setOnClickListener()
        {
            val intent = Intent(this, ViewDetails_activity::class.java)
            intent.putExtra("shopName",viewShopname.lowercase())
            startActivity(intent)
        }

        btnDelete.setOnClickListener()
        {
            stockNumber = parseInt(txtStockNumber.text.toString())

            val factory = ShopFactory()

            if (shopname.lowercase()=="checkers")
            {
                var shop = factory.makeShop(ShopType.Checkers)
                var result = shop?.DeleteStock(stockNumber)
            }else if (shopname.lowercase()=="shoprite")
            {
                var shop = factory.makeShop(ShopType.Shoprite)
                var result = shop?.DeleteStock(stockNumber)
            }
        }
    }
}