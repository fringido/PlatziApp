package com.platzi.conf.viewmodel.adapter

import com.platzi.conf.model.Speaker

interface SpeakerListener {
    fun onSpeakerClicked(speaker: Speaker, position: Int)
}