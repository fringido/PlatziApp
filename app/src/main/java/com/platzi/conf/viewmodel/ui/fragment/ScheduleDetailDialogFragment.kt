package com.platzi.conf.viewmodel.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.platzi.conf.R

/**
 * A simple [Fragment] subclass.
 * Use the [ScheduleDetailDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScheduleDetailDialogFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule_detail_dialog, container, false)
    }

}