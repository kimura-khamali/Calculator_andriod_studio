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
lateinit var  etnum1:EditText//declare a variable and call int later
lateinit var  etnum2:EditText
lateinit var btn_add: Button
lateinit var btn_sabtruct:Button
lateinit var btn_multiplication:Button
lateinit var btn_division:Button
lateinit var tvResult:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
        btn_add.setOnClickListener{
           val num1 = etnum1.text.toString().toInt()
           val num2 = etnum2.text.toString().toInt()
            val sum = num1+num2
            tvResult.text = sum.toString()
        }
        btn_sabtruct.setOnClickListener{
            val num1 = etnum1.text.toString().toInt()
            val num2 = etnum2.text.toString().toInt()
            val subtruction = num1-num2
            tvResult.text = subtruction.toString()
        }
        btn_multiplication.setOnClickListener{
            val num1 = etnum1.text.toString().toInt()
            val num2 = etnum2.text.toString().toInt()
            val multiplication = num1*num2
            tvResult.text = multiplication.toString()
        }
        btn_division.setOnClickListener{
            val num1 = etnum1.text.toString().toInt()
            val num2 = etnum2.text.toString().toInt()
            val division= num1/num2
            tvResult.text = division.toString()
        }
    }

    fun castViews(){
        etnum1 = findViewById(R.id.etnum1)
        etnum2 = findViewById(R.id.etnum2)
        btn_add = findViewById(R.id.btn_add)
        btn_sabtruct = findViewById(R.id.btn_subtract)
        btn_multiplication = findViewById(R.id.btn_multiplication)
        btn_division = findViewById(R.id.btn_division)
        tvResult = findViewById(R.id.tvResult)
    }
}