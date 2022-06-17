package com.hayde117.muheez.activityview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hayde117.muheez.R
import com.hayde117.muheez.databinding.ActivityCategorySixViewBinding

class CategorySixViewActivity : AppCompatActivity() {


    private lateinit var binding: ActivityCategorySixViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategorySixViewBinding.inflate(layoutInflater)
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