package com.realityexpander.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class OrderedReceiver2 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        var resultCode = resultCode
        var resultData = resultData
        val resultExtras = getResultExtras(true)
        var stringExtra = resultExtras.getString("stringExtra")

        resultCode++
        stringExtra += "->OR2"

        val toastText = """
            OR2
            resultCode: $resultCode
            resultData: $resultData
            stringExtra: $stringExtra
            Thread: ${Thread.currentThread().name}
            """.trimIndent()
        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()

        Thread.sleep(500)

        resultData = "OR2"
        resultExtras.putString("stringExtra", stringExtra)
        setResult(resultCode, resultData, resultExtras)

        //abortBroadcast()  // Shows example of how to cancel the broadcast, and its always received by the last receiver.
    }
}