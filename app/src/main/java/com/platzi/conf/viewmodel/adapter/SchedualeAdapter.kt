package com.platzi.conf.viewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.platzi.conf.R
import com.platzi.conf.model.Conference
import java.text.SimpleDateFormat

class SchedualeAdapter(val scheduleListener: ScheduleListener) : RecyclerView.Adapter<SchedualeAdapter.ViewHolder>(){

    var listConference = ArrayList<Conference>()

    //Crear o decir cual sera el diseno usado para nuestra lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false))

    //Los datos que vayamos a crear
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val conference = listConference[position] as Conference

        holder.tvConferenceName.text = conference.title
        holder.tvConferenceSpeaker.text = conference.speaker
        holder.tvConferenceTag.text = conference.tag

        val simpleDataFormat = SimpleDateFormat("HH:mm")
        val simpleDateformatAMPM = SimpleDateFormat("a")
        cal.time = conference.datetime
        val hourFormat = simpleDataFormat.format(conference.datetime)

        holder.tvConferenceHour.text = hourFormat
        holder.tvConferenceAMPM.text = simpleDateformatAMPM.format(conference.datetime)
    }

    fun updateData(data: List<Conference>){
        listConference.clear()
        listConference.addAll(data)
        notifyDataSetChanged()
    }
    //Cuantos elementos tenemos
    override fun getItemCount() = listConference.size

        //clase interna de como podemos enlasar a los elementos visuales
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceName)
            val tvConferenceSpeaker = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceSpeaker)
            val tvConferenceTag = itemView.findViewById<TextView>(R.id.tvItemScheduleTag)
            val tvConferenceHour = itemView.findViewById<TextView>(R.id.tvItemScheduleHour)
            val tvConferenceAMPM = itemView.findViewById<TextView>(R.id.tvItemScheduleAMPM)
        }
}

