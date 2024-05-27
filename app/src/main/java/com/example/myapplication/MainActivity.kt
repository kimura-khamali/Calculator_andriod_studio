package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var etnum1: EditText//declare a variable and call int later
    lateinit var etnum2: EditText
    lateinit var btn_add: Button
    lateinit var btn_sabtruct: Button
    lateinit var btn_multiplication: Button
    lateinit var btn_division: Button
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
       btn_add.setOnClickListener {
           validate("+")

     }
    btn_sabtruct.setOnClickListener {
        validate("-")

     }
   btn_multiplication.setOnClickListener {

      }
      btn_division.setOnClickListener {
          validate("/")
       }
    }

    fun castViews() {
        etnum1 = findViewById(R.id.etnum1)
        etnum2 = findViewById(R.id.etnum2)
        btn_add = findViewById(R.id.btn_add)
        btn_sabtruct = findViewById(R.id.btn_subtract)
        btn_multiplication = findViewById(R.id.btn_multiplication)
        btn_division = findViewById(R.id.btn_division)
        tvResult = findViewById(R.id.tvResult)

    }

    fun validate(sign:String){
//        val num1 = etnum1.text.toString().toInt()
//        val num2 = etnum2.text.toString().toDouble()
        val num1 = etnum1.text.toString()
        val num2 = etnum2.text.toString()
        var inputError = false
        if (num1.isBlank()){
            inputError = true
            etnum1.error = "Num 1 is required"
        }
        if (num2.isBlank()){
            inputError = true
            etnum2.error = "Num 2 is required"
        }
        if (!inputError){
            calculate(num1.toDouble(),num2.toDouble(),sign)
        }
    }
    fun calculate(num1:Double,num2:Double,sign:String){
//        val num1 = etnum1.text.toString().toInt()
//        val num2 = etnum2.text.toString().toDouble()
        var result = 0.0

        when(sign){
            "+"->result= num1+num2
            "-"->result= num1-num2
            "*"->result= num1*num2
            "/"->result= num1/num2
        }
tvResult.text = result.toString()
    }
}

