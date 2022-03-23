package com.example.muheez.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.muheez.activityview.CategoryTwoViewActivity
import com.example.muheez.MyAdapter
import com.example.muheez.R
import com.example.muheez.User
import com.example.muheez.databinding.ActivityCategoryFiveBinding

class CategoryFiveActivity : AppCompatActivity() {


    private lateinit var binding: ActivityCategoryFiveBinding

    private lateinit var userArrayList: ArrayList<User>


    // private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryFiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(
            R.drawable.iot_energy_1,
            R.drawable.iot_energy_2,
            R.drawable.iot_energy_3,
            R.drawable.iot_energy_4,
            R.drawable.iot_energy_5

        )
        val name = arrayOf("IOT Smart Light, Temperature & Air Control ", "IOT Energy Management Systems", "IOT Green Energy Solutions", "IOT Energy Storage",
            "IOT Stations, Plants, Solar & Wind Fields")

        val dev = arrayOf("Energy", "Energy", "Energy", "Energy", "Energy")

        val info = arrayOf("Ranked Number 1", "Ranked Number 2", "Ranked Number 3", "Ranked Number 4", "Ranked Number 5")

        val dev_iot = arrayOf(


            "The most obvious way to save energy is to cut down on wasting it. Smart lighting, learning thermostats and sensor-based HVAC systems of the new generation are designed to automatically maintain the perfect conditions in spaces and keep energy use at the optimum level.\n" +
                    "\n" +
                    "Equipped with different sensors (light, movement, humidity, CO2 level, etc.) these systems can dynamically adjust the regimes depending on the changing conditions and avoid using energy in potential waste points.\n" +
                    "\n" +
                    "Thus, smart lighting dims depending on the amount of daylight available in the room and automatically turns off once the room is empty. Learning thermostats precool the space before the heat comes to avoid using expensive energy at the peak load time.\n" +
                    "\n" +
                    "Current by General Electric is a good example of an Internet of Things energy management solution. The Company provides a set of LED light, sensors, controls and analytics tools to create a smart energy infrastructure in industrial and commercial spaces, including factories, stores and the whole cities. The solution is promised to save up to 70% on electric bills.\n" +
                    "\n" +
                    "Philips Hue and Ecobee 4 are lighting and smart thermostat solutions which also provide enormous savings, but for households. Philips Hue family of products include outdoor and indoor LED lighting which adjusts to people’s preferences and routines and uses 85% less energy than traditional bulbs. Ecobee 4 thermostat which automatically cuts down on the use of the energy when it’s the most expensive offers an additional 33% energy saving.",


            // Second

            "Smart bulbs and thermostats are popular home automation tools that demonstrate how Internet of Things and energy management provide savings without much effort on the user’s side.\n" +
                    "\n" +
                    "Digital energy management systems include sensors, meters, controls, applications and analytics tools that enable users — households, businesses, energy professionals, communities, governments — to monitor, manage and control processes, assets and resources in the supply chain.\n" +
                    "\n" +
                    "Smart meters, for example, monitor power consumption in real-time, dynamically calculate spending and share data between end-users and utility companies. This data helps suppliers tailor demand-response programs and adjust pricing. Residents, in turn, can control their electricity usage at a granular level using applications, respond to load changes, limit wasting energy.\n" +
                    "\n" +
                    "Sensor-enabled assets, be it heavy machinery on a plant or a household boiler, can continuously report load and predict overheating, risks of damage or outage on the line. In the case of the plant’s equipment — motors, for example, — prevented damage results in serious savings. Using tracking data analytics, management can find the right balance between optimum performance of the equipment, wear and energy use and ensure a long life for the assets.\n" +
                    "\n" +
                    "WebNMS is a great example of the Internet of Things energy management system for industrial and commercial spaces. Using the datum coming from a network of sensors and meters on-site, the solution provides saving measures to optimize the use of energy and maximize productivity.\n" +
                    "\n" +
                    "Sense is a smart metering system for households. It is connected to a regular electric panel to enable residents to gain full control and visibility in their energy usage and proactively participate in energy management.",

            //third

            "Today, we can use Internet of Things for energy management and expanding the adoption of green energy. IoT-based residential solar systems and wind turbines offer free power to partially or fully fulfill a household’s energy demand.\n" +
                    "\n" +
                    "In the first case, residential renewables cut the average energy bill by 50%. In the second case, this number goes up to 100% and allows a household goes completely off-grid.\n" +
                    "\n" +
                    "Not only does the adoption of residential renewable power systems help save energy, but also to reduces carbon footprint and contributes to the environment conservation initiative.\n" +
                    "\n" +
                    "The example of Schneider Electric solutions for households and smart buildings is a great IoT energy management case study. The company provides a wide range of industrial, commercial and residential solar solutions, as well as full-scale PV power plants.\n" +
                    "\n" +
                    "Each solution consists of a set of connected hardware such as gateways, power banks, batteries, meters and converters and software for real-time power monitoring and control. Depending on the purpose and configuration, Schneider Electric’s solutions enable full energy independence, efficient backup or hybridization with other power sources.",

            //fourth

            "Energy storage is a whole new market. It is gaining attention in the wake of the recent trends in smart home sector and the growing role of IoT in smart city concept.\n" +
                    "\n" +
                    "In general, storage allows consumers to maintain energy independence in the case of an outage or other problem on the line. Smart storage enables controlled and efficient energy backup and gives residents management functions.\n" +
                    "\n" +
                    "In the case of smart storage, for example, the residents can make informed decisions on the loads and choose which loads should be protected, how much energy should be spent in the off-grid mode and where.\n" +
                    "\n" +
                    "Moreover, using smart storage, the adopters of solar and other renewables can now better manage the clean energy they generate, control the surplus and ensure maximized performance for their power network.\n" +
                    "\n" +
                    "In other words, energy storage is the application of Internet of Things in energy management which enables saving energy both directly and indirectly.\n" +
                    "\n" +
                    "Lumin Energy Management Platform is an example of a smart storage and electricity metering solution which provides customers with monitoring and management capabilities and simplifies the adoption of solar in residential buildings.\n" +
                    "\n",
            //fifth


            "Another application of IoT for saving energy is focused on optimizing the very source of power production. Stations, plants, solar fields and wind turbines also consume energy, require maintenance and a wide range of effort and resource-heavy works to keep them running. Using IoT in this sector, or Internet of Energy Things, is the right way to maximize the performance.\n" +
                    "\n" +
                    "Resource management in Internet of Energy Things implies a complex of measures to optimize the performance at a power grid. It includes using sensors, data analytics, predictive maintenance and other practices.\n" +
                    "\n" +
                    "Continuous condition monitoring of equipment and wiring using sensors, for example, prevents overloads and helps maintain a balanced load on the line. Predictive maintenance ensures the timely repair of the equipment and prevents blackouts, accidents and costly downtime.\n" +
                    "\n" +
                    "In some cases, connecting power plants and renewable grids into a network gives consumers a transparent view of where their energy comes from. And with this information, consumers get a choice to use the cleanest source available at the moment.\n" +
                    "\n" +
                    "This is exactly what Whatttime platform offers to people. The nonprofit organization provides technology solutions to enable “automated emission reduction.” In short, the system monitors the network of grids and dynamically shifts to the power source which produces the least emissions at a given time.\n" +
                    "\n" +
                    "With this application of Internet of Things, electric utilities that produce the cleanest energy get more consumers, reduce carbon-heavy energy and ensure better environmental practices."
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