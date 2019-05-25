package kr.co.woobi.imyeon.stopwatchkotlin.flashLight

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import kr.co.woobi.imyeon.stopwatchkotlin.toast

class TorchReceiver : BroadcastReceiver( ) {
    override fun onReceive(context: Context, intent: Intent) {
        context.toast("손전등 켜짐")
    }


}