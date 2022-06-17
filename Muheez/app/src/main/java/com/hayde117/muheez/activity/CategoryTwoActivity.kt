package com.hayde117.muheez.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hayde117.muheez.activityview.CategoryTwoViewActivity
import com.hayde117.muheez.MyAdapter
import com.hayde117.muheez.R
import com.hayde117.muheez.User
import com.hayde117.muheez.databinding.ActivityCategoryTwoBinding

class CategoryTwoActivity : AppCompatActivity() {


    private lateinit var binding: ActivityCategoryTwoBinding

    private lateinit var userArrayList: ArrayList<User>


    // private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageId = intArrayOf(
            R.drawable.iot_trans_1,
            R.drawable.iot_trans_2,
            R.drawable.iot_trans_3,
            R.drawable.iot_trans_4,
            R.drawable.iot_trans_5

        )

        val name = arrayOf("IOT Traffic Management", "IOT Toll and Ticketing", "IOT Connected Cars", "IOT Vehicle Tracking Systems", "IOT Public Transport Management",
        )

        val dev = arrayOf("Transportation", "Transportation", "Transportation", "Transportation", "Transportation")

        val info = arrayOf("Ranked Number 1", "Ranked Number 2", "Ranked Number 3", "Ranked Number 4", "Ranked Number 5")

        val dev_iot = arrayOf(

            "When it comes to implementing IoT technologies in transport, the first goal is traffic jam problem-solving. The American Transportation Research Institute estimates that congestion costs the U.S. freight sector  74.1 billion annually. Traffic management Internet of Things solutions allows you to increase the capacity of city streets without actually adding new roads and play a vital role in the transition to smart cities.\n\nThey optimize traffic flow and keep traffic safe using sensors, cameras, routers, and cellular technologies to dynamically adjust controls such as traffic lights, highway exit counters, expressway bus lanes, highway bulletin boards, and even speed limits.\n\nFor example, Ford has introduced Traffic Jam Assist, a mode that allows the vehicle to match the car’s speed in front of a traffic jam. This speed matching makes it easier for drivers and smooth traffic flows, and reduces congestion patterns.\n\nIn the future, these systems will be able to directly control vehicles when needed – for example, breaking them at intersections to prevent collisions with pedestrians or other vehicles.\n\nApplication for traffic jams using IoT technology include:\n\nSmart parking. IoT sensors in parking lots can transmit information about accessible parking spaces in real-time.\n\nIoT traffic light. Sensors installed in strategic locations can use IoT technology to collect data on congestion, moving vehicles away from these locations. IoT Big Data solutions can analyze this information, determine alternative routes, and improve traffic signaling to reduce congestion. \n\nRoadside lights can also work by the weather sensors installed on them. With a light control system, roadside lighting will change with the onset of day or night and when weather conditions require it.\n\nSmart ambulance. Video surveillance systems and road sensors can help locate incidents and report them to the nearest emergency room.",
            // Second
            "Conventional toll systems are becoming rapidly outdated. With the increase in vehicles on the roads, queues at toll booths have become a common sight, not to mention the manpower needed to operate toll booths on busy highways. Whilst automated tolls, using a RFID tag, have improved the flow of traffic, further improvements have been made possible by the use of IoT technology. \n\nMany of today’s modern vehicles are equipped with IoT connectivity. A vehicle can be detected up to a kilometre away from a tolling station, correctly identified and the barrier lifted for the vehicle to pass through. Alternatively, for older vehicles, a registered smartphone could serve the same purpose, taking automatic payment from the digital wallet linked on the phone",
            //third

            "A connected car in IoT is a vehicle with internet access and connection of devices inside and outside. There are three main IoT technologies which are actively used in cars for connection: \n\n" +
                    "advanced telematics;\n" +
                    "Car2X-communication;\n" +
                    "NFC.\n\n" +
                    "For example, with such short-range wireless technology like Near-field communication (NFC), Bluetooth and WiFi pairing has become faster and easier. Besides this, NFC also has a significant role in developing smartphone-centric solutions and new business models in the spheres of fleet management, car rental and sharing.\n" +
                    "\n\n" +
                    "Connected cars and the Internet of Things enable the data exchange which is carried at the following five levels:" +
                    "\n\n" +
                    "vehicle to infrastructure (V2I);\n" +
                    "vehicle to vehicle (V2V);\n" +
                    "vehicle to pedestrians (V2P);\n" +
                    "vehicle to cloud (V2C);\n" +
                    "vehicle to everything (V2X)." +
                    "\n\n" +
                    "V2X combines all the levels stated above. These connections make a significant impact on the whole advancement of the road infrastructure.",


            //fourth
             "Vehicle tracking systems are typically used within the freight segment to help companies manage their fleets effectively. They also help to monitor driver behaviour and can collect data which informs on idling time and driving style. Examples of IoT-powered functionality include:\n\n Trip scheduling \nFleet tracking \nDriving times and driver rest break scheduling \nAlerts for speeding, harsh cornering, acceleration or braking\nMonitoring of vehicle load\nDistance travelled and fuel consumption",

            //fifth

             "The public transport segment uses innovative transport technologies such as passenger information systems, integrated ticketing, automated toll collection, passenger information display systems, and advanced transport logistics solutions. They all use IoT technologies that offer the following benefits:\n\nReal-time vehicle tracking for arrival time alerts via mobile devices and information displays for passengers at stops and stations.\nPersonalized transport timetable tracking with information on fundamental changes such as delays, station closings, or re-routing.\nReal-time data tracking helps build the correct route due to unforeseen incidents such as accidents, road works, emergencies, etc"
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


