package com.example.muheez.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.muheez.activityview.CategoryTwoViewActivity
import com.example.muheez.MyAdapter
import com.example.muheez.R
import com.example.muheez.User
import com.example.muheez.databinding.ActivityCategorySevenBinding

class CategorySevenActivity : AppCompatActivity() {



    private lateinit var binding: ActivityCategorySevenBinding

    private lateinit var userArrayList: ArrayList<User>


    // private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategorySevenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val imageId = intArrayOf(
            R.drawable.google_iot,
            R.drawable.amazon_iot,
            R.drawable.kuri_iot,
            R.drawable.smart_lock,
            R.drawable.door_bell_iot
        )

        val name = arrayOf("IOT Google Home Voice Controller", "IOT Amazon Echo Plus Voice Controller", "IOT Kuri Mobile Robot", "IOT August Smart Lock", "IOT August Doorbell Cam",
        )

        val dev = arrayOf("Home", "Home", "Home", "Home", "Home")

        val info = arrayOf("Ranked Number 1", "Ranked Number 2", "Ranked Number 3", "Ranked Number 4", "Ranked Number 5")

        val dev_iot = arrayOf(

            "Google Home Voice Controller is a smart IoT device which allows the user to enjoy features like media, alarms, lights, thermostats, control the volume and much more functions just by their voice.\n" +
                    "\n" +
                    "Top Features:\n" +
                    "\n" +
                    "Google home allows a user to listen to media.\n" +
                    "Let’s the user to control TV and speakers.\n" +
                    "It is capable of managing timers and alarms.\n" +
                    "It can remotely handle the volume and home lights as well.\n" +
                    "It helps the user to plan their day and get things done automatically.\n" +
                    "Company Website: Google Home Voice Controller",

            // Second
            "Amazon Echo Plus voice controller is a popular and reliable IoT device. It is capable to run songs, do phone calls, set timers and alarms, ask questions, provide information, check the weather, manage to-do & shopping lists, manage house instruments, and several other things.\n" +
                    "\n" +
                    "Top Features:\n" +
                    "\n" +
                    "Amazon Echo can play songs, connect to external speakers or headphones.\n" +
                    "It is capable of making calls and messaging on voice command.\n" +
                    "Amazon Echo has around 6-7 microphones, good technical specification and sound cancellation. It is capable of hearing your voice from all the directions even when songs are played.\n" +
                    "Controls compatible smart home devices including lights, plugs, and more.",


            //third

            "Kuri is the first sort of home robot and most popular too. It is specifically designed for entertainment. Kuri interacts with the users and captures moments all around the house daily.\n" +
                    "\n" +
                    "Top Features:\n" +
                    "\n" +
                    "Kuri has capacitive touch sensors and HD camera.\n" +
                    "It is integrated with gestural mechanics and microphones.\n" +
                    "It has heart light and speakers.\n" +
                    "It includes integrated mapping sensors and drives system.\n" +
                    "It has a good processor and a smooth charging pad.",

            //fourth

            "August Smart Lock has proven to be a reliable security IoT device. It allows the user to manage their doors from any location hassle-free. It helps the user to keep thieves away and family in your home.\n" +
                    "\n" +
                    "Top Features:\n" +
                    "\n" +
                    "Allows the user to know about each and every person coming and going into your home.\n" +
                    "Provides unlimited digital keys and no fear of stolen key.\n" +
                    "It gives the status updates of your door as it is properly closed or not.\n" +
                    "It has a good auto-unlock feature and as soon as the user arrives near the door it opens automatically.\n" +
                    "Easy installation and is compatible with most standard single cylinder deadbolts.",

            //fifth

        "August Doorbell Cam is an effective IoT innovation. August Doorbell Cam allows you to answer your door from anywhere or remote location. It constantly checks your doors and also captures motion changes in your doorstep.\n" +
                "\n" +
                "Top Features:\n" +
                "\n" +
                " Doorbell Cam pairs with all August Smart Locks to easily let guests into your home.\n" +
                "The integrated floodlight delivers clear, full-color HD video even full-color.\n" +
                "It constantly monitors your doorstep and will click the moments leading up to a motion alert.\n" +
                "Free 24 hour video recording.\n" +
                "It comes with a speedy and hassle-free installation process."

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