package com.example.alexs.loterias

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LotomaniaActivity : AppCompatActivity() {

    lateinit var tvConcurso : TextView
    lateinit var tvNum1 : TextView
    lateinit var tvNum2 : TextView
    lateinit var tvNum3 : TextView
    lateinit var tvNum4 : TextView
    lateinit var tvNum5 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lotomania)

    }
}
