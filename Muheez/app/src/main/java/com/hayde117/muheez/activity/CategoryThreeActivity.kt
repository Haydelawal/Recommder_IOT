package com.hayde117.muheez.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hayde117.muheez.activityview.CategoryTwoViewActivity
import com.hayde117.muheez.MyAdapter
import com.hayde117.muheez.R
import com.hayde117.muheez.User
import com.hayde117.muheez.databinding.ActivityCategoryThreeBinding

class CategoryThreeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryThreeBinding

    private lateinit var userArrayList: ArrayList<User>


    // private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val imageId = intArrayOf(
            R.drawable.iot_health_1,
            R.drawable.iot_health_2,
            R.drawable.iot_health_3,
            R.drawable.iot_health_4,
            R.drawable.iot_health_5

        )

        val name = arrayOf("IOT Remote Patient Monitoring", "IOT Glucose Monitoring", "IOT Heart-rate Monitoring", "IOT Hand Hygiene Monitoring", "IOT Depression And Mood Monitoring",
        )

        val dev = arrayOf("Health Care", "Health Care", "Health Care", "Health Care", "Health Care")

        val info = arrayOf("Ranked Number 1", "Ranked Number 2", "Ranked Number 3", "Ranked Number 4", "Ranked Number 5")

        val dev_iot = arrayOf(
            "Remote patient monitoring is the most common application of IoT devices for healthcare. IoT devices can automatically collect health metrics like heart rate, blood pressure, temperature, and more from patients who are not physically present in a healthcare facility, eliminating the need for patients to travel to the providers, or for patients to collect it themselves. \n" +
                    "\n" +
                    "When an IoT device collects patient data, it forwards the data to a software application where healthcare professionals and/or patients can view it. Algorithms may be used to analyze the data in order to recommend treatments or generate alerts. For example, an IoT sensor that detects a patient’s unusually low heart rate may generate an alert so that healthcare professionals can intervene.\n" +
                    "\n" +
                    "A major challenge with remote patient monitoring devices is ensuring that the highly personal data that these IoT devices collect is secure and private.\n" +
                    "\n",

            // Second

            "For the more than 30 million Americans with diabetes, glucose monitoring has traditionally been difficult. Not only is it inconvenient to have to check glucose levels and manually record results, but doing so reports a patient’s glucose levels only at the exact time the test is provided. If levels fluctuate widely, periodic testing may not be sufficient to detect a problem.\n" +
                    "\n" +
                    "IoT devices can help address these challenges by providing continuous, automatic monitoring of glucose levels in patients. Glucose monitoring devices eliminate the need to keep records manually, and they can alert patients when glucose levels are problematic.\n" +
                    "\n" +
                    "Challenges include designing an IoT device for glucose monitoring that:\n" +
                    "a. Is small enough to monitor continuously without causing a disruption to patients\n" +
                    "b. Does not consume so much electricity that it needs to be recharged frequently.\n" +
                    "\n" +
                    "These are not insurmountable challenges, however, and devices that address them promise to revolutionize the way patients handle glucose monitoring.",
            //third

            "Like glucose, monitoring heart rates can be challenging, even for patients who are present in healthcare facilities. Periodic heart rate checks don’t guard against rapid fluctuations in heart rates, and conventional devices for continuous cardiac monitoring used in hospitals require patients to be attached to wired machines constantly, impairing their mobility.\n" +
                    "\n" +
                    "Today, a variety of small IoT devices are available for heart rate monitoring, freeing patients to move around as they like while ensuring that their hearts are monitored continuously. Guaranteeing ultra-accurate results remains somewhat of a challenge, but most modern devices can deliver accuracy rates of about 90 percent or better.",

            //fourth

            "Traditionally, there hasn’t been a good way to ensure that providers and patients inside a healthcare facility washed their hands properly in order to minimize the risk of spreading contagion.\n" +
                    "\n" +
                    "Today, many hospitals and other health care operations use IoT devices to remind people to sanitize their hands when they enter hospital rooms. The devices can even give instructions on how best to sanitize to mitigate a particular risk for a particular patient.\n" +
                    "\n" +
                    "A major shortcoming is that these devices can only remind people to clean their hands; they can’t do it for them. Still, research suggests that these devices can reduce infection rates by more than 60 percent in hospitals.",

            //fifth

        "Information about depression symptoms and patients’ general mood is another type of data that has traditionally been difficult to collect continuously. Healthcare providers might periodically ask patients how they are feeling, but were unable to anticipate sudden mood swings. And, often, patients don’t accurately report their feelings.\n" +
                "\n" +
                "“Mood-aware” IoT devices can address these challenges. By collecting and analyzing data such as heart rate and blood pressure, devices can infer information about a patient’s mental state. Advanced IoT devices for mood monitoring can even track data such as the movement of a patient’s eyes.\n" +
                "\n" +
                "The key challenge here is that metrics like these can’t predict depression symptoms or other causes for concern with complete accuracy. But neither can a traditional in-person mental assessment."
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