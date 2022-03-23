package com.example.muheez

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context: Activity, private val  arrayList: ArrayList<User>)

    : ArrayAdapter<User>(context, R.layout.list_item, arrayList) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.list_item, null)

        val imageView : ImageView = view.findViewById(R.id.iot_pic)
        val iot_name : TextView = view.findViewById(R.id.Name)

        val iot_dev : TextView = view.findViewById(R.id.developer)
//        val iot_rank : TextView = view.findViewById(R.id.rank)

        imageView.setImageResource(arrayList[position].imageId)
        iot_name.text = arrayList[position].name
        iot_dev.text = arrayList[position].dev
//        iot_rank.text = arrayList[position].rank



        return view
    }
}