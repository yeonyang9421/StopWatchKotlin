package kr.co.woobi.imyeon.stopwatchkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(StopWatchViewModel::class.java)
        viewModel.time.observe(this, androidx.lifecycle.Observer { time ->
            val sec = time / 100
            val milli = time % 100
            text_sec.text = "$sec"
            text_milli.text = "$milli"
        })

        viewModel.isRunning.observe(this, androidx.lifecycle.Observer { isRunning ->
            if (isRunning) {
                button_start.text = "Pause"
            } else {
                button_start.text = "Start"
            }
        })
        button_start.setOnClickListener {
            viewModel.onStartButtonClicked()
        }
    }
}
