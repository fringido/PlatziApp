package com.platzi.conf.viewmodel.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.platzi.conf.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(findViewById(R.id.toolBarMain))

        configNav()
    }

    fun configNav()
    {
        NavigationUI.setupWithNavController(btnMenu, Navigation.findNavController(this, R.id.fragContent)
    }
}