package com.example.demotaskkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demotaskkotlin.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle : Bundle?=intent.extras

        val name = bundle!!.getString("name")
        val price = bundle.getString("price")
        val type= bundle.getString("type")


        binding.txtName.text = name
        binding.txtPrice.text = price
        binding.txtType.text = type



    }
}