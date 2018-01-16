package com.example.alexs.loterias

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject

class Quina2Activity : AppCompatActivity() {

    lateinit var tvConcurso : TextView
    lateinit var tvNum1 : TextView
    lateinit var tvNum2 : TextView
    lateinit var tvNum3 : TextView
    lateinit var tvNum4 : TextView
    lateinit var tvNum5 : TextView

    lateinit var btnMeusJogos : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quina2)

        tvConcurso = findViewById(R.id.tvConcurso)
        tvNum1 = findViewById(R.id.tvNum1)
        tvNum2 = findViewById(R.id.tvNum2)
        tvNum3 = findViewById(R.id.tvNum3)
        tvNum4 = findViewById(R.id.tvNum4)
        tvNum5 = findViewById(R.id.tvNum5)

        var it = intent
        var js = JSONObject(it.getStringExtra("json"))

//        btnMeusJogos.setOnClickListener({onclickMeusJogos(it,js)})

        tvConcurso.text = js.getString("numero").toString()

        tvNum1.text = js.getJSONArray("sorteio").get(0).toString()
        tvNum2.text = js.getJSONArray("sorteio").get(1).toString()
        tvNum3.text = js.getJSONArray("sorteio").get(2).toString()
        tvNum4.text = js.getJSONArray("sorteio").get(3).toString()
        tvNum5.text = js.getJSONArray("sorteio").get(4).toString()
    }
}
