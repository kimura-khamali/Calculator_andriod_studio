package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            validate("+")
        }
        binding.btnSubtract.setOnClickListener {
            validate("-")
        }
        binding.btnMultiplication.setOnClickListener {
            validate("*")
        }
        binding.btnDivision.setOnClickListener {
            validate("/")
        }
    }

    fun validate(sign: String) {
        val num1Str = binding.etnum1.text.toString()
        val num2Str = binding.etnum2.text.toString()

        // Check if num1 and num2 are integers or decimals
        val num1IsDecimal = num1Str.contains(".")
        val num2IsDecimal = num2Str.contains(".")

        var inputError = false
        if (num1Str.isBlank()) {
            inputError = true
            binding.etnum1.error = "Num 1 is required"
        } else if ((num1IsDecimal && !num2IsDecimal) || (!num1IsDecimal && num2IsDecimal)) {
            inputError = true
            binding.etnum1.error = "Both numbers should be either integers or decimals"
        }
        if (num2Str.isBlank()) {
            inputError = true
            binding.etnum2.error = "Num 2 is required"
        } else if ((num1IsDecimal && !num2IsDecimal) || (!num1IsDecimal && num2IsDecimal)) {
            inputError = true
            binding.etnum2.error = "Both numbers should be either integers or decimals"
        }

        if (!inputError) {
            // Convert to Double since we want to support both integers and decimals
            calculate(num1Str.toDouble(), num2Str.toDouble(), sign)
        }
    }

    fun calculate(num1: Double, num2: Double, sign: String) {
        var result = 0.0

        when (sign) {
            "+" -> result = num1 + num2
            "-" -> result = num1 - num2
            "*" -> result = num1 * num2
            "/" -> {
                if (num2 != 0.0) {
                    result = num1 / num2
                } else {
//                    binding.tvResult.text = "Error: Division by zero"
                    return
                }
            }
        }
        binding.tvResult.text = result.toString()
    }
}