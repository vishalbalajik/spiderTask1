package com.example.android.spidertask1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.spidertask1.databinding.ActivityCheckerBinding
import kotlin.math.sqrt
@SuppressLint("StaticFieldLeak")
private lateinit var binding:ActivityCheckerBinding
class Checker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.check.setOnClickListener {
            val velocit=binding.checkerVelocity.text.toString()
            val velocity = velocit.toDouble()
            val c: Long = 300000000
            val gamma :Double= 1 / (sqrt(1 - ((velocity * velocity) / (c * c))))
            val x=binding.inputLorentz.text.toString()
            val xx=x.toDouble()
            if(gamma==xx){
                binding.tickCross.setImageResource(R.drawable.tick)
            }
            else{
                binding.tickCross.setImageResource(R.drawable.cross)
            }
        }
        binding.backToCalculator.setOnClickListener {
            intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
        binding.SpiFactor.setOnClickListener {
            intent= Intent(this,Spi::class.java)
            startActivity(intent)
        }


    }
}
