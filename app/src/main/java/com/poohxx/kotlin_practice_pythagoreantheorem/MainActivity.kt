package com.poohxx.kotlin_practice_pythagoreantheorem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.poohxx.kotlin_practice_pythagoreantheorem.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun onClickResult(view: View){
     if (!isFieldEmpty()){
         val result =  getString(R.string.result_info) + getResult()
         binding.tvResult.text = result
     }
    }
    private fun isFieldEmpty(): Boolean {
        binding.apply {
            if (edSideA.text.isNullOrEmpty()) edSideA.error = getString(R.string.errorEmpty)
            if (edSideB.text.isNullOrEmpty()) edSideB.error = getString(R.string.errorEmpty)
            return edSideA.text.isNullOrEmpty() || edSideB.text.isNullOrEmpty()
        }
    }
    private fun getResult():String{
        val a: Double
        val b: Double
        binding.apply {
            a = edSideA.text.toString().toDouble()
            b = edSideB.text.toString().toDouble()
        }
        return sqrt     ((a.pow(2)   )+ b.pow(2)).toString()
    }
}