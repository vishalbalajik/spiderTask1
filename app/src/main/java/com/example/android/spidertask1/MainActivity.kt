package com.example.android.spidertask1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.android.spidertask1.databinding.ActivityMainBinding
import kotlin.math.sqrt

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lorentzImage.visibility= View.INVISIBLE
        binding.textView2.visibility= View.INVISIBLE
        binding.calculatorVelocity.visibility= View.INVISIBLE
        binding.answer.visibility= View.INVISIBLE
        binding.calculate.visibility= View.INVISIBLE
        binding.calculator.visibility= View.INVISIBLE
        binding.checker.visibility=View.INVISIBLE

        binding.lorentzFactor.setOnClickListener {
         binding.calculator.visibility= View.VISIBLE
         binding.checker.visibility=View.VISIBLE
        }
        binding.calculator.setOnClickListener {
            gammaCalculator()
        }
        binding.checker.setOnClickListener {
            intent= Intent(this,Checker::class.java)
            startActivity(intent)
        }
        binding.spiFactor.setOnClickListener {
            intent= Intent(this,Spi::class.java)
            startActivity(intent)
        }

    }
}
@SuppressLint("SetTextI18n")
fun gammaCalculator(){
    binding.answer.text = "--answer--"
    binding.lorentzImage.visibility=View.VISIBLE
    binding.textView2.visibility=View.VISIBLE
    binding.calculatorVelocity.visibility=View.VISIBLE
    binding.answer.visibility=View.VISIBLE
    binding.calculate.visibility=View.VISIBLE
    binding.calculator.setOnClickListener {
        val velocit=binding.calculatorVelocity.text.toString()
        val velocity = velocit.toDouble()
        val c: Double= 300000000.0
        val gamma = 1 / (sqrt(1 - ((velocity * velocity) / (c * c))))
        binding.answer.text = "γ=$gamma"
    }
}
