package com.platzi.conf.viewmodel.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.GridLayoutManager
import com.platzi.conf.R
import com.platzi.conf.viewmodel.adapter.SpeakerAdapter
import com.platzi.conf.viewmodel.adapter.SpeakerListener
import kotlinx.android.synthetic.main.fragment_speakers.*
import com.platzi.conf.viewmodel

class SpeakersFragment : Fragment(), SpeakerListener {

    private lateinit var speakerAdapter: SpeakerAdapter

    private lateinit var viewModel: SpeakersViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(SpeakersViewModel::class.java)

        viewModel.refresh()

        speakerAdapter = SpeakerAdapter(this)

        rvSpeakers.apply {
            layoutManager = GridLayoutManager(view.context,2)
            adapter = speakerAdapter
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.listSpeaker.observe(this,
            Observer<List<Speaker>> { speakers ->
                speakerAdapter.updateData(speakers)
            })

        viewModel.isLoading.observe(this, Observer<Boolean> {
            if (it != null)
                rlBaseSpeaker.visibility = View.INVISIBLE
        })
    }

    override fun onSpeakerClicked(speaker: Speaker, position: Int) {
        val bundle = bundleOf("speaker" to speaker)
        findNavController().navigate(R.id.speakersDetailFragmentDialog, bundle)
    }

}