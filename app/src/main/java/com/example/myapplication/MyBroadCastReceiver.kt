package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadCastReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirPlaneModeEnabled = intent?.getBooleanExtra("state",false)

        when(isAirPlaneModeEnabled){

            true -> Toast.makeText(context,"the airplane mode is enabled",Toast.LENGTH_LONG).show()
            false -> Toast.makeText(context,"the airplane mode is disabled",Toast.LENGTH_LONG).show()
        }
    }
}