package kr.co.woobi.imyeon.stopwatchkotlin.flashLight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_torch.*
import kr.co.woobi.imyeon.stopwatchkotlin.R

class Torch : AppCompatActivity(), View.OnClickListener {



    override fun onClick(v: View?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_torch)
        button1.setOnClickListener(this)
    }
}
