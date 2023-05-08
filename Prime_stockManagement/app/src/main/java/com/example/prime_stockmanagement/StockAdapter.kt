package com.example.prime_stockmanagement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StockAdapter(private val stockList : ArrayList<StockData>) : RecyclerView.Adapter<StockAdapter.StockViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.stock_item,parent,false)
        return StockViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return stockList.size
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        val currentItem = stockList[position]

        holder.StockBarcode.text = currentItem.StockBarCode
        holder.StockName.text = currentItem.StockName
        holder.StockPrice.text = currentItem.StockPrice.toString()
        holder.StockQTY.text = currentItem.StockQTY.toString()
    }

    class StockViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val StockBarcode : TextView = itemView.findViewById(R.id.viewBarcode)
        val StockName : TextView = itemView.findViewById(R.id.viewName)
        val StockPrice : TextView = itemView.findViewById(R.id.viewPrice)
        val StockQTY : TextView = itemView.findViewById(R.id.viewQTY)
    }
}