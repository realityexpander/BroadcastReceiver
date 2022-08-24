package com.realityexpander.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class OrderedReceiver3 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        var resultCode = resultCode
        var resultData = resultData
        val resultExtras = getResultExtras(true)
        var stringExtra = resultExtras.getString("stringExtra")

        resultCode++
        stringExtra += "->OR3"

        val toastText = """
            OR3
            resultCode: $resultCode
            resultData: $resultData
            stringExtra: $stringExtra
            Thread: ${Thread.currentThread().name}
            """.trimIndent()
        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()

        Thread.sleep(500)

        resultData = "OR3"
        resultExtras.putString("stringExtra", stringExtra)
        setResult(resultCode, resultData, resultExtras)
    }
}