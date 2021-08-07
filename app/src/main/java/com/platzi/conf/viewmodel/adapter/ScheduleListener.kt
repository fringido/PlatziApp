package com.platzi.conf.viewmodel.adapter

import com.platzi.conf.model.Conference


interface ScheduleListener
{
    fun onConferenceClick(conference: Conference, position: Int)
}