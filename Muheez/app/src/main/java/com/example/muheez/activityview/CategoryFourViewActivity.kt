package com.example.muheez.activityview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.muheez.R
import com.example.muheez.databinding.ActivityCategoryFourViewBinding

class CategoryFourViewActivity : AppCompatActivity() {


    private lateinit var binding: ActivityCategoryFourViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryFourViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val developer = intent.getStringExtra("developer")

        val info = intent.getStringExtra("info")
        val imageId = intent.getIntExtra("imageId", R.drawable.aaa)

        binding.nameOfDevice.text = name
        binding.devOfDevice.text = info
        binding.infoOfDevice.text = developer

        binding.profileImage.setImageResource(imageId)


    }
}