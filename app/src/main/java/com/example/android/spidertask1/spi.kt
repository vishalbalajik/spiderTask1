package com.example.android.spidertask1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.android.spidertask1.databinding.ActivitySpiBinding
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@SuppressLint("StaticFieldLeak")
private lateinit var binding:ActivitySpiBinding
class Spi : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val currentTime=LocalTime.now()
        binding.timeDisplay.text=currentTime.format((DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)))
        val time = SpiVariables()
        time.timeH=currentTime.hour
        time.timeM=currentTime.minute
        time.timeS=currentTime.second
        val spi = (fact(time.timeH)) / ((time.timeM * time.timeM * time.timeM) + time.timeS)
        binding.spiValue.text = "φ=$spi"
        binding.button.setOnClickListener {
            intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

    }
}
class SpiVariables(){
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