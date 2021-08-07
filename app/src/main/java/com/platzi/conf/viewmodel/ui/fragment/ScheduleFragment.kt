package com.platzi.conf.viewmodel.ui.fragment

import android.os.Bundle
import android.telecom.Conference
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.platzi.conf.R
import com.platzi.conf.viewmodel.ScheduleViewModel
import com.platzi.conf.viewmodel.adapter.SchedualeAdapter
import com.platzi.conf.viewmodel.adapter.ScheduleListener
import kotlinx.android.synthetic.main.fragment_schedule.*

class ScheduleFragment : Fragment(), ScheduleListener {
    private lateinit var scheduleAdapter: SchedualeAdapter
    private lateinit var viewModel: ScheduleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScheduleViewModel::class.java)
        viewModel.refresh()

        scheduleAdapter = SchedualeAdapter(this)

        rvSchedule.apply {
            layoutManager = LinerLayoutManager(view.context, LinerLayoutManager.VERTICAL, false)
            adapter = scheduleAdapter
        }
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.listSchedule.observe(viewLifecycleOwner, Observer<List<Conference>>{ schedule ->
            scheduleAdapter.updateData(schedule)
        })

        viewModel.isLoading.observe(this, Observer<Boolean> {
            if(it != null )
                rlBaseSchedule.visibility = View.INVISIBLE
        })
    }

    override fun onConferenceClick(conference: com.platzi.conf.model.Conference, position: Int) {
        val bundle = bundleOf("conference" to conference)
        findNavController().navigate(R.id.scheduleDetailFragmentDialog, bundle)
    }
}