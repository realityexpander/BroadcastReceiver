package com.realityexpander.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class OrderedReceiver1 : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var resultCode = resultCode
        var resultData = resultData
        val resultExtras = getResultExtras(true) // makeMap rebuilds the map and ensures no nulls
        var stringExtra = resultExtras.getString("stringExtra")

        resultCode++ // example of modifying the resultCode
        stringExtra += "->OR1" // example of modifying the resultExtras

        val toastText = """
               OR1
               resultCode: $resultCode
               resultData: $resultData
               stringExtra: $stringExtra
               Thread: ${Thread.currentThread().name}
               """.trimIndent()
        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()

        resultData = "OR1"  // example of setting result for the next receiver
        resultExtras.putString("stringExtra", stringExtra)
        setResult(resultCode, resultData, resultExtras)
    }
}