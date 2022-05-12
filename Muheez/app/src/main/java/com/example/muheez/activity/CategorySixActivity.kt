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


           "Digital technologies are becoming increasingly important for cities to have the conditions for continuous development; buildings and urban infrastructures must be planned more efficiently and sustainably. Cities should also invest in electric cars and self-propelled vehicles to keep CO2 emissions low. \n\nIn fact, intelligent technologies to achieve an energy-efficient and environmentally friendly infrastructure. For example, to reduce the need for electrical power, smart lighting only gives light when someone actually walks past smart lights; setting brightness levels and tracking daily use are both important components of smart lights." +
                   "\n\nIn today’s time, implementing smart cities that leverage IoT and connected technology help promote economic development, improve infrastructure and environment, enhance transportation systems, and optimize costs of managing public assets.\n" +
                   "\n" +
                   "Connected technologies and IoT solutions for smart cities play important roles in transforming cities. Implementing a smart city with IoT and connected technology helps enhance the quality, performance, interactivity of urban services and optimize resources that reduce costs.\n" +
                   "\n" +
                   "The global market for smart urban infrastructure in smart cities includes advanced connected streets, smart parking, smart lighting, and other transportation innovations. Examples are:\n" +
                   "\n" +
                   "Smart Lighting\n" +
                   "Connected Streets\n" +
                   "Smart Parking Management",


            // Second

            "Smart cities also are implementing tools that can capture pollution data in real time and forecast emissions. Being able to predict air pollution accurately allows cities to get to the root of their emissions problems and brainstorm strategic ways to limit the amount of air pollution they put out.\n\n" +
                    "One of the most alarming issues in modern cities is the air quality level, where air pollution has caused 120 deaths out of 100,000 per year based on a worldwide study (Green Car Congress, 2019).\n" +
                    "\n" +
                    "The World Health Organization emphasized that 97% of cities in low- and middle- income countries with more than 100 000 inhabitants do not meet World Health Organization (WHO) air quality guidelines.\n" +
                    "\n" +
                    "Due to poor air quality, it will increase potential health risks such as risk of stroke, heart disease, lung cancer, asthma and others as well (citation). Hence, there is a need to install an air quality monitoring system in cities to ensure the air is not contaminated. \n" +
                    "\nThis can be done by installing sensors to monitor dust particles, carbon dioxide, carbon monoxide, nitrogen dioxide and sulfur dioxide levels and this information can be shared with the public through smartphones, where the smartphone app allows people to monitor real-time data of the current air quality level in the area. Hence, through these implementations, better quality of life can be achieved.",
           //third

            "One of the most significant infrastructure challenges faced by emerging countries today is traffic management. Developed nations and smart cities are already taking advantage of IoT to reduce traffic congestion. People in all kinds of countries have quickly established a vehicle culture. " +
                    "\n" +
                    "\n" +
                    "People in most cities prefer to drive their own cars, regardless of how good or awful public transit is or how much time and money it would take to get to their destination." +
                    "\n\n" +
                    "As a result, the growing usage of automobiles has resulted in massive traffic congestion. Several nations are addressing this traffic bottleneck by obtaining data from CCTV feeds and transferring vehicle-related data to city traffic control centers in order to assist in the creation of improvements." +
                    "" +
                    "\n" +
                    "\n" +
                    "Better-organized traffic systems result in a smoother flow of traffic and fewer idle automobiles, buses, and trucks stuck in traffic jams. All of this correlates to shorter run times, more efficient use of natural resources (gas), and less pollution." +
                    "\n\n" +
                    "Stop-start driving produces the most gas emissions, which occurs in areas where traffic is controlled by lights. As a result, opting for smart traffic helps to reduce pollution across the city." +
                    "\n\n" +
                    "Smart traffic management, on the other hand, includes elements such as smart parking sensors, smart lighting, smart roads, and smart accident aid, among others such as:" +
                    "" + " \n\n" +
                    "Managing Traffic Lights\n" +

                    "Management and Prevention of Road - Accidents\n" +
                    "Cameras and Sensors\n" +
                    "Parking with Insight",

            //fourth

                "An IoT based smart parking system, also known as a connected parking system, is a centralized management system that allows drivers to use a smartphone app to search for and reserve a parking spot.\n" +
                        "\n" +
                        "The system’s hardware features sensors that detect available parking slots and communicate this information to all drivers in the area. This data is updated in real-time, which means drivers never have to worry about not finding an available space.\n" +
                        "\n" +
                        "In addition to helping drivers find a spot, the system also sends alerts about peak times and peak prices. The goal of these alerts is to help save drivers money while also reducing congestion.\n" +
                        "\n" +
                        "How Does Iot Based Parking System Work?\n" +
                        "Parking systems are installed on the outside of buildings or inside of buildings. When a vehicle enters the space, sensors detect its presence and calculate available parking slots. This information is then sent to the driver’s phone via an app.\n" +
                        "\n" +
                        "The smart parking system also has real-time data on occupancy rates, which can be found on the app. This data is collected from each sensor and is updated every five minutes.\n" +
                        "\n" +
                        "One major drawback of automated parking system is that it has increased competition for parking spaces in urban areas with limited space nearby. However, even though these systems are helpful for drivers, there are some drawbacks to this type of initiative.\n" +
                        "\n" +
                        "Drivers who rely on public transportation may not have the ability to use this app because they don’t own a car or drive their own vehicle. These systems also require a lot of maintenance because many sensors need to be replaced often due to wear and tear or vandalism.",

            //fifth

        "IoT powered smart management solutions focus on improving the total efficiency of waste collection and recycling. The most common IoT use case in waste management is route optimisation, which reduces fuel consumption while emptying the waste dumpsters throughout the city." +
                "\n\n" +
                "Most popular and feasible smart waste management solutions consist of endpoints (sensors), gateways, IoT platforms, and web and mobile applications. A sensor is attached to a waste bin to measure its fill level. Gateways play the role of bridging the gap between the IoT platform and sensor, sending data from the sensor to the cloud. Some edge-processing capable gateways are also needed. These devices process the raw data." +
                "" +
                "\n\n" +
                " The IoT platform does the job of transforming the raw data into information. Most of the time, the IoT platforms are hosted in the Cloud, but sometimes due to high data security requirements, they can also be hosted on the premises as well.\n" +
                "" +
                "\n\n" +
                "Different sensors can be used to perform different tasks. Ultrasonic level sensors are the most commonly used sensors in smart waste management IoT solutions. Other sensors include motion sensors, GPS sensors, light sensors, and vibration sensors to monitor various parameters, including location, temperature, and theft."


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