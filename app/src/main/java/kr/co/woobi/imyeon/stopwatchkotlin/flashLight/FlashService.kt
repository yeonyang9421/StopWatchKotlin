package kr.co.woobi.imyeon.stopwatchkotlin.flashLight

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kr.co.woobi.imyeon.stopwatchkotlin.flashLight.Flash

class FlashService : Service() {
    private val flash: Flash by lazy {
        Flash(this)
    }

    private var isRunning = false

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            "on" -> {
                flash.flashOn()
                isRunning=true
            }
            "off" -> {
                flash.flashOff()
                isRunning=false
            }
            else ->{
                isRunning=!isRunning
                if(isRunning){
                    flash.flashOn()
                }else{
                    flash.flashOff()
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
