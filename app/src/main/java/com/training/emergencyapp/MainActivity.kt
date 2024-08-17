package com.training.emergencyapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val emergencies= arrayListOf<Emergency>()
        emergencies.add(Emergency(R.drawable.child_image, getString(R.string.child_rescue),"16000"))
        emergencies.add(Emergency(R.drawable.fire_image, getString(R.string.fire_truck),"180"))
        emergencies.add(Emergency(R.drawable.police_image, getString(R.string.police),"122"))


        val adapter=EmergencyAdapter(this,emergencies)
        val rv:RecyclerView=findViewById(R.id.rv)
        rv.adapter=adapter

    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        val exit=ExitDialog()
        exit.isCancelable=false
        exit.show(supportFragmentManager,null)
        //super.onBackPressed()
    }
}