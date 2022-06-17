package com.hayde117.muheez.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hayde117.muheez.activityview.CategoryOneViewActivity
import com.hayde117.muheez.MyAdapter
import com.hayde117.muheez.R
import com.hayde117.muheez.User
import com.hayde117.muheez.databinding.ActivityCategoryOneBinding

class CategoryOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryOneBinding

    private lateinit var userArrayList: ArrayList<User>


    // private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryOneBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val imageId = intArrayOf(
            R.drawable.iot_indus_1,
            R.drawable.iot_indus_2,
            R.drawable.iot_indus_3,
            R.drawable.iot_indus_4,
            R.drawable.iot_indus_5

        )

        val name = arrayOf("IOT Monitoring Equipment Utilization", "IOT Product Quality Control", "IOT Safety Monitor", "IOT Asset Tracking", "IOT Inventory Management",
            )

        val dev = arrayOf("Industry/Manufacturing", "Industry/Manufacturing", "Industry/Manufacturing", "Industry/Manufacturing", "Industry/Manufacturing")

        val info = arrayOf("Ranked Number 1", "Ranked Number 2", "Ranked Number 3", "Ranked Number 4", "Ranked Number 5")

        val dev_iot = arrayOf("These IoT applications for manufacturing deal with operations such as monitoring and optimizing equipment performance, production quality control, and human-to-machine interaction. \n\nIoT applications for monitoring machine utilization can increase manufacturing productivity by 10 to 25% and produce up to 1.8 trillion in global economic value by 2025. \n\nIoT solutions for monitoring machine utilization provide businesses with real-time equipment utilization metrics, thus offering a detailed view of what is occurring at every point of the production process. \n\n Monitoring machine utilization starts with pulling relevant data about machine operating parameters, e.g., run time, actual operating speed, product output, etc., from sensors, SCADA or DCS systems. The data is gathered in real time and transmitted to the cloud for processing. The cloud aggregates the data and develops it into informative insights about equipment utilization KPIs (TEEP, OEE, setup and adjustment time, idling and minor stops, etc.). After the data is analyzed, the results are visualized and displayed to the factory workers via a user app (either web or mobile). ",

          // Second
            "This IOT device monitors the quality of the produced goods in two ways: by inspecting a WIP (work in progress) as it moves through the production cycle or by monitoring the condition and calibration of machines on which a product is manufactured. Although quality control based on inspecting WIPs provides more accurate results (it helps to uncover minor defects, say, inaccuracies in parts alignment), there are certain limitations that hinder the method’s usage: \n\n Quality control based on WIP inspection is applicable only for discrete manufacturing. \n It is costly, time- and labor-intensive, as the WIPs are inspected manually.\n It is rarely possible to inspect every WIP, therefore, the method provides a fractional view.\n The second method, based on monitoring the condition and calibration of machines, offers less differentiation in terms of scope - it provides simple binary classification “good” and “not good”. However, it helps to detect bottlenecks in the manufacturing operations, identify badly tuned and/or underperforming machines, timely prevent machine damages, and more. \n\n. To monitor the quality of the production process, such parameters as equipment calibration, machine conditions (speed, vibration, etc.) and environmental conditions (temperature, humidity, etc.) are monitored to identify when they go beyond the normal thresholds. If sensor readings are approaching the thresholds that can lead to a potential product defect, a quality monitoring solution pinpoints the source of an issue, triggers an alert and recommends a mitigating action to fix or tune the machine and minimize the production of low-quality products.",

           //third
            "This IOT device has RFID tags worn by workers that gather data on their location and wearable sensors collecting data about their heart rate, skin temperature, galvanic skin response, and other parameters. \n\nThe sensor data is relayed to the cloud where it is analyzed against contextual data (e.g. from environmental sensors, legacy work planning systems, weather feeds, etc.) to detect unusual behavior patterns (say, sudden vertical movements, unusual heart rates, etc.), and prevent workers from falls, overexertion, and other injuries and timely report a safety threat. \n\n For instance, a combination of high skin temperature, a raised heart rate, and no movement patterns for about a minute could indicate that a person suffers from overheating. Whenever such a situation is recognized, an IoT solution notifies an employee’s responsible person (a worker’s manager, a doctor, etc.) via a mobile application.",

            //fourth
            "IoT industrial asset management provides accurate real-time data about enterprise’s assets, their statuses, locations and movements, IoT-based asset management solutions remove the tracking burden from the employees (freeing up to 18 hours of monthly working time) and eliminate errors bound to the manual methods of data input. \n\nTo enable asset tracking for manufacturing, IoT works together with RFID. Each asset – be it a magnetic locator or a crane – gets labeled with an RFID tag, which serves as an asset identifier. Each tag has a unique ID, which is linked to the data about a particular asset. Both the ID and the corresponding asset data is stored in the cloud. The asset data may include the asset’s physical parameters, cost, serial number, model, assigned employee, area of use, etc. \n\nOnce an asset, say, a crane, leaves an equipment storage yard, an RFID reader installed at the yard entrance, scans the tag attached to the crane and saves the record about the asset leaving the yard to an in-cloud database. Similarly, when the crane enters, say, a construction site, an RFID reader at the construction site entrance scans the tag and updates the data in the database. Logging such data throughout the asset’s journey allows technicians to see the movements of the assets. \n\nAlong with that, GPS tracking can be used to state the location of the movable assets, for instance, machines used in construction. For movable items, asset tracking solutions are also used to calculate utilization. For instance, seeing for how long each movable (say, a bulldozer) is in use, technicians can pinpoint idling or underused machines and schedule preventive maintenance. ",

            //fifth
            "IOT Inventory management solutions applied in the manufacturing settings are based on IoT and RFID technologies. Each inventory item gets labeled with a passive RFID tag. Each tag has a unique ID that carries the data about the item the tag is attached to. To fetch the data from the tags, RFID readers are used.\n\n A reader catches tags’ IDs and relays them to the cloud for storing and processing. To establish the location and the movements of the scanned tags, along with the tags’ IDs, the data about the location of the RFID reader and the time of the reading are relayed to the cloud. The cloud pinpoints the location and the status of each item, visualizes the findings and displays them to the users")

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


            val i = Intent(this, CategoryOneViewActivity::class.java)
            i.putExtra("name", name)
            i.putExtra("developer", dev_iot)
            i.putExtra("info", info)
            i.putExtra("imageId", imageId)

            startActivity(i)

        }
    }
}