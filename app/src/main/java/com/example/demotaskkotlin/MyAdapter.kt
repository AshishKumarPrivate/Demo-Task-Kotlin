package com.example.demotaskkotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val dataList: ArrayList<DataModelClass> ,val context : Context) : RecyclerView.Adapter<MyAdapter.holder>() {

//    private lateinit var mlistener : onitemClickListener
//    interface onitemClickListener{
//        fun onItemClick(position: Int)
//    }
//    fun setOnItemClickListener(listener : onitemClickListener){
//        mlistener = listener
//
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cell_trading_item, parent, false)
       return holder(itemView)
    }


    override fun onBindViewHolder(holder: holder, position: Int) {
        val  singleItem = dataList[position]

        holder.name.setText(singleItem.name)
        holder.price.setText(singleItem.price)
        holder.type.setText(singleItem.type)

        holder.itemView.setOnClickListener {
            Toast.makeText(context , "position"+singleItem.name ,Toast.LENGTH_SHORT).show()
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("name", singleItem.name)
            intent.putExtra("price", singleItem.price)
            intent.putExtra("type", singleItem.type)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class holder(itemView: View ) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.txt_name)
        val price: TextView = itemView.findViewById(R.id.txt_price)
        val type: TextView = itemView.findViewById(R.id.txt_type)

//        init {
//            itemView.setOnClickListener {
//                listener.onItemClick(adapterPosition)
//            }
//        }

    }
}