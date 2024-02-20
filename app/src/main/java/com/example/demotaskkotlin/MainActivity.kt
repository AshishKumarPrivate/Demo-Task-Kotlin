package com.example.demotaskkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demotaskkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityMainBinding
    lateinit var dataArrayList: ArrayList<DataModelClass>
    lateinit var nameArray : Array<String>
    lateinit var priceArray : Array<String>
    lateinit var typeArray : Array<String>
    lateinit var itemView : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        nameArray = arrayOf("John Smith 1","John Smith 2","John Smith 3","John Smith 4","John Smith 5")
        priceArray = arrayOf("$1.25","$3.11","$4.25","$8.25","$10.25")
        typeArray = arrayOf("Micro","ECN ","ECN Pro","ECN Plus","ECN")

        dataArrayList = ArrayList<DataModelClass>()
        for (i in nameArray.indices){
          val  data = DataModelClass(nameArray[i],priceArray[i],typeArray[i])
            dataArrayList.add(data)
        }

        val adapter = MyAdapter(dataArrayList , this);
        binding.recyclerView.layoutManager = LinearLayoutManager(this);
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter

//        adapter.setOnItemClickListener(object :  MyAdapter.onitemClickListener{
//            override fun onItemClick(position: Int) {
//                val intent = Intent(this@MainActivity,DetailActivity::class.java)
//                intent.putExtra("name", dataArrayList[position].name)
//                intent.putExtra("price", dataArrayList[position].price)
//                intent.putExtra("type", dataArrayList[position].type)
//                startActivity(intent)
//            }
//
//        })

        binding.hangBurger.setOnClickListener {
            Toast.makeText(this, "Coming soon",Toast.LENGTH_SHORT).show()
        }

        binding.notification.setOnClickListener {
            Toast.makeText(this, "Coming soon",Toast.LENGTH_SHORT).show()
        }


    }
}