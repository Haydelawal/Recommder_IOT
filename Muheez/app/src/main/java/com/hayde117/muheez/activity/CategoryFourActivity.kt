package com.hayde117.muheez.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hayde117.muheez.activityview.CategoryTwoViewActivity
import com.hayde117.muheez.MyAdapter
import com.hayde117.muheez.R
import com.hayde117.muheez.User
import com.hayde117.muheez.databinding.ActivityCategoryFourBinding

class CategoryFourActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryFourBinding

    private lateinit var userArrayList: ArrayList<User>


    // private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(
            R.drawable.iot_agric_1,
            R.drawable.iot_agric_2,
            R.drawable.iot_agric_3,
            R.drawable.iot_agric_4,
            R.drawable.iot_agric_5

        )

        val name = arrayOf("IOT Climate Condition Monitor", "IOT Greenhouse Automation", "IOT Crop Management", "IOT Cattle Monitoring And Management", "IOT Agricultural Drones",
        )

        val dev = arrayOf("Agriculture", "Agriculture", "Agriculture", "Agriculture", "Agriculture")

        val info = arrayOf("Ranked Number 1", "Ranked Number 2", "Ranked Number 3", "Ranked Number 4", "Ranked Number 5")

        val dev_iot = arrayOf(


            "Probably the most popular smart agriculture gadgets are weather stations, combining various smart farming sensors. Located across the field, they collect various data from the environment and send it to the cloud. The provided measurements can be used to map the climate conditions, choose the appropriate crops, and take the required measures to improve their capacity (i.e. precision farming).\n" +
                    "\n" +
                    "Some examples of such agriculture IoT devices are allMETEO, Smart Elements, and Pycno.",

            // Second

            "Typically, farmers use manual intervention to control the greenhouse environment. The use of IoT sensors enables them to get accurate real-time information on greenhouse conditions such as lighting, temperature, soil condition, and humidity.\n" +
                    "\n" +
                    "In addition to sourcing environmental data, weather stations can automatically adjust the conditions to match the given parameters. Specifically, greenhouse automation systems use a similar principle.\n" +
                    "\n" +
                    "For instance, Farmapp and Growlink are also IoT agriculture products offering such capabilities among others.\n" +
                    "\n" +
                    "GreenIQ is also an interesting product that uses smart agriculture sensors. It is a smart sprinklers controller that allows you to manage your irrigation and lighting systems remotely.",

            //third

            "One more type of IoT product in agriculture and another element of precision farming are crop management devices. Just like weather stations, they should be placed in the field to collect data specific to crop farming; from temperature and precipitation to leaf water potential and overall crop health.\n" +
                    "\n" +
                    "Thus, you can monitor your crop growth and any anomalies to effectively prevent any diseases or infestations that can harm your yield. Arable and Semios can serve as good representations of how this use case can be applied in real life.\n" +
                    "\n",

            //fourth

            "Just like crop monitoring, there are IoT agriculture sensors that can be attached to the animals on a farm to monitor their health and log performance. Livestock tracking and monitoring help collect data on stock health, well-being, and physical location.\n" +
                    "\n" +
                    "For example, such sensors can identify sick animals so that farmers can separate them from the herd and avoid contamination. Using drones for real-time cattle tracking also helps farmers reduce staffing expenses. This works similarly to IoT devices for petcare.\n" +
                    "\n" +
                    "For example, SCR by Allflex and Cowlar use smart agriculture sensors (collar tags) to deliver temperature, health, activity, and nutrition insights on each individual cow as well as collective information about the herd.",

            //fifth

            "Perhaps one of the most promising agritech advancements is the use of agricultural drones in smart farming. Also known as UAVs (unmanned aerial vehicles), drones are better equipped than airplanes and satellites to collect agricultural data. Apart from surveillance capabilities, drones can also perform a vast number of tasks that previously required human labor: planting crops, fighting pests and infections, agriculture spraying, crop monitoring, etc.\n" +
                    "\n" +
                    "DroneSeed, for example, builds drones for planting trees in deforested areas. The use of such drones is 6 times more effective than human labor. A Sense Fly agriculture drone eBee SQ uses multispectral image analyses to estimate the health of crops and comes at an affordable price.\n" +
                    "\n"

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