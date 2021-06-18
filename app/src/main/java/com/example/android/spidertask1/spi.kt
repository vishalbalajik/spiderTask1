package com.example.android.spidertask1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.android.spidertask1.databinding.ActivitySpiBinding
import java.time.LocalTime

@SuppressLint("StaticFieldLeak")
private lateinit var binding:ActivitySpiBinding
class Spi : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val currentTime2= TextClock(this)
        //currentTime2.format12Hour = "hh:mm:ss a"
        //binding.timeDisplay.text = "Time: " + currentTime2.text
        binding.button.setOnClickListener {
            intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
        object : CountDownTimer(60000000000000000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val time = SpiVariables()
                val currentTime= LocalTime.now()
                time.timeH=currentTime.hour
                time.timeM=currentTime.minute
                time.timeS=currentTime.second
                val spi = (fact(time.timeH)) / ((time.timeM * time.timeM * time.timeM) + time.timeS)

                binding.timeDisplay.text="Current Time:"+time.timeH+":"+time.timeM+":"+time.timeS
                binding.spiValue.text = "φ=$spi"
            }

            override fun onFinish() {}
        }.start()
    }
}
class SpiVariables {
    var timeH:Int=0
    var timeM:Int=0
    var timeS:Int=0
}
fun fact(x: Int): Double {
    var factorial=1.0
    var x=x
    repeat(x - 1){
        factorial*=x
        --x
    }
    return factorial
}

