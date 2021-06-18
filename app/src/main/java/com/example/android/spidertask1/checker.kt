package com.example.android.spidertask1

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android.spidertask1.databinding.ActivityCheckerBinding
import java.lang.String.format
import kotlin.math.sqrt


@SuppressLint("StaticFieldLeak")
private lateinit var binding:ActivityCheckerBinding
class Checker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        binding.backToCalculator.setOnClickListener {
            intent= Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        binding.SpiFactor.setOnClickListener {
            intent= Intent(this, Spi::class.java)
            startActivity(intent)
        }
        binding.check.setOnClickListener {
            if (vibrator.hasVibrator()) { // Vibrator availability checking
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE)) // New vibrate method for API Level 26 or higher
                } else {
                    vibrator.vibrate(80) // Vibrate method for below API Level 26
                }
            val velocit=binding.checkerVelocity.text.toString()
            val velocity = velocit.toDouble()
            if(velocity<=0||velocity>=300000000){
                Toast.makeText(this,"Invalid velocity value", Toast.LENGTH_SHORT).show()
                intent= Intent(this,Checker::class.java)
                startActivity(intent)
            }
            val c: Long = 300000000
            val gamma :Double= 1 / (sqrt(1 - ((velocity * velocity) / (c * c))))
            val gamma2=format("%.6f",gamma)
            val x=binding.inputLorentz.text.toString()
            val xx=x.toDouble()
            val xxx=format("%.6f",xx)
            if(gamma2==xxx&&velocity>0&&velocity<300000000){
                binding.tickCross.visibility=View.VISIBLE
                binding.tickCross.setImageResource(R.drawable.tick)
            }
            else{
                binding.tickCross.visibility=View.VISIBLE
                binding.tickCross.setImageResource(R.drawable.cross)
            }
        }
        }
        binding.reset2.setOnClickListener {
            binding.checkerVelocity.text=null
            binding.inputLorentz.text=null
            binding.tickCross.visibility= View.INVISIBLE
        }
}}
