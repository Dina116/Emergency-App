package com.training.emergencyapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class EmergencyAdapter(val activity: Activity,val emergencies: ArrayList<Emergency>): RecyclerView.Adapter<EmergencyAdapter.MVH>() {
    class MVH(view: View):RecyclerView.ViewHolder(view) {
        val parent: CardView =view.findViewById(R.id.parent)
        val image: ImageView =view.findViewById(R.id.image)
        val tvName: TextView =view.findViewById(R.id.tv_name)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmergencyAdapter.MVH {
       val view=activity.layoutInflater.inflate(R.layout.emergency_list_item,parent,false)
        return MVH(view)
    }

    override fun onBindViewHolder(holder: EmergencyAdapter.MVH, position: Int) {
        holder.image.setImageResource(emergencies[position].image)
        holder.tvName.text=emergencies[position].name
        holder.parent.setOnClickListener {
            activity.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:${emergencies[position].number}")))
        }
    }

    override fun getItemCount()= emergencies.size

}