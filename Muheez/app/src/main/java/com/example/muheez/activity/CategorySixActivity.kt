package com.example.muheez.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.muheez.activityview.CategoryTwoViewActivity
import com.example.muheez.MyAdapter
import com.example.muheez.R
import com.example.muheez.User
import com.example.muheez.databinding.ActivityCategorySixBinding

class CategorySixActivity : AppCompatActivity() {


    private lateinit var binding: ActivityCategorySixBinding

    private lateinit var userArrayList: ArrayList<User>


    // private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategorySixBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val imageId = intArrayOf(
            R.drawable.iot_city_1,
            R.drawable.iot_city_2,
            R.drawable.iot_city_3,
            R.drawable.iot_city_1,
            R.drawable.iot_city_5

        )

        val name = arrayOf("IOT  Smart Infrastructure", "IOT Air Quality Management", "IOT Traffic Management", "IOT Smart Parking", "IOT Smart Waste Management",
        )

        val dev = arrayOf("Smart City", "Smart City", "Smart City", "Smart City", "Smart City")

        val info = arrayOf("Ranked Number 1", "Ranked Number 2", "Ranked Number 3", "Ranked Number 4", "Ranked Number 5")

        val dev_iot = arrayOf(


           "Digital technologies are becoming increasingly important for cities to have the conditions for continuous development; buildings and urban infrastructures must be planned more efficiently and sustainably. Cities should also invest in electric cars and self-propelled vehicles to keep CO2 emissions low. In fact, intelligent technologies to achieve an energy-efficient and environmentally friendly infrastructure. For example, to reduce the need for electrical power, smart lighting only gives light when someone actually walks past smart lights; setting brightness levels and tracking daily use are both important components of smart lights.",


            // Second

            "Smart cities also are implementing tools that can capture pollution data in real time and forecast emissions. Being able to predict air pollution accurately allows cities to get to the root of their emissions problems and brainstorm strategic ways to limit the amount of air pollution they put out.",
           //third

            "One of the greatest challenges facing large cities is finding ways to optimize traffic. Yet, finding a solution is not impossible. For example, Los Angeles is one of the busiest cities in the world and has implemented an intelligent transport solution to control the traffic flow. Pavement integrated sensors send real-time updates of traffic flow to a central traffic management platform, which analyses the data and automatically adjusts traffic lights to the traffic situation within seconds. At the same time, historical data is used to predict where traffic can go – and none of these processes require human involvement.",
            //fourth

            "Cities are also leveraging intelligent parking solutions that identify when a vehicle has left the parking area. Sensors are built into the ground and report the location of free parking spaces via a mobile app the driver downloads. Others use vehicle feedback to precisely pinpointing the location of openings and guide waiting cars down the path of least resistance. Smart Parking is a reality today and does not require complicated infrastructure and a high investment, making this smart city application ideal for a mid-sized smart city initiative.",
            //fifth


            "Waste management solutions help to optimize the efficiency of waste collection and reduce operational costs while better addressing any and all environmental issues associated with inefficient waste collection. In these solutions, the waste container receives a level sensor; when a certain threshold is reached, the management platform of a truck driver receives a notification via their smartphone. The message helps them avoid half empty drains by appearing to empty a full container."
        )


        userArrayList = ArrayList()

        for(i in name.indices){

            val user = User(name[i], dev[i], info[i], dev_iot[i], imageId[i])
            userArrayList.add(user)
        }


        binding.listView.isClickable = true
        binding.listView.adapter = MyAdapter(this, userArrayList)
        binding.listView.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val info = info[position]

            val dev_iot = dev_iot[position]
            val imageId = imageId[position]


            val i = Intent(this, CategoryTwoViewActivity::class.java)
            i.putExtra("name", name)
            i.putExtra("developer", dev_iot)
            i.putExtra("info", info)
            i.putExtra("imageId", imageId)

            startActivity(i)

        }
    }
}