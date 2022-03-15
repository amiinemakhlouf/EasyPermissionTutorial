package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class myService :Service() {
    override fun onBind(p0: Intent?): IBinder? =null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val data =intent?.getStringExtra("extra")
        Thread.sleep(2000)
        Toast.makeText(this,"${data}",Toast.LENGTH_SHORT).show()

        return START_STICKY
    }

}