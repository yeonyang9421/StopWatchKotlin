package kr.co.woobi.imyeon.stopwatchkotlin.flashLight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_flash_light.*
import kr.co.woobi.imyeon.stopwatchkotlin.R

class FlashLightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_light)

        val flash= Flash(this)

        switch_Flash.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                flash.flashOn()
                val intent=Intent(this, FlashService::class.java)
                intent.setAction("on")
                startService(intent)
            }else{
                val intent1= Intent(this, FlashService::class.java)
                intent1.setAction("off")
                startService(intent1)
            }
        }
    }
}

