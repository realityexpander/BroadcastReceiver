package com.realityexpander.broadcastreceiver

import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// Video series: https://www.youtube.com/watch?v=prueLyTvOwI&list=PLrnPJCHvNZuBqr_0AS9BPXgU6gvNeai5S

class MainActivity : AppCompatActivity() {
    var orderedReceiver1: OrderedReceiver1 = OrderedReceiver1()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Dynamically Registered Broadcast Receiver
        val filter = IntentFilter("com.realityexpander.EXAMPLE_ACTION")
        filter.priority = 1
        registerReceiver(orderedReceiver1, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(orderedReceiver1)
    }
}