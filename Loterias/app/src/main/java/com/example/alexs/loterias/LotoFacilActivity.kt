package com.example.alexs.loterias

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.GridLayout
import android.widget.TextView
import org.json.JSONObject

class LotoFacilActivity : AppCompatActivity() {

    lateinit var tvConcurso : TextView
    lateinit var tvNum1 : TextView
    lateinit var tvNum2 : TextView
    lateinit var tvNum3 : TextView
    lateinit var tvNum4 : TextView
    lateinit var tvNum5 : TextView
    lateinit var tvNum6 : TextView
    lateinit var tvNum7 : TextView
    lateinit var tvNum8 : TextView
    lateinit var tvNum9 : TextView
    lateinit var tvNum10 : TextView
    lateinit var tvNum11 : TextView
    lateinit var tvNum12 : TextView
    lateinit var tvNum13 : TextView
    lateinit var tvNum14 : TextView
    lateinit var tvNum15 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loto_facil)

        tvConcurso = findViewById(R.id.tvConcursoNum)
        tvNum1 = findViewById(R.id.tvNum1)
        tvNum2 = findViewById(R.id.tvNum2)
        tvNum3 = findViewById(R.id.tvNum3)
        tvNum4 = findViewById(R.id.tvNum4)
        tvNum5 = findViewById(R.id.tvNum5)
        tvNum6 = findViewById(R.id.tvNum6)
        tvNum7 = findViewById(R.id.tvNum7)
        tvNum8 = findViewById(R.id.tvNum8)
        tvNum9 = findViewById(R.id.tvNum9)
        tvNum10 = findViewById(R.id.tvNum10)
        tvNum11 = findViewById(R.id.tvNum11)
        tvNum12 = findViewById(R.id.tvNum12)
        tvNum13 = findViewById(R.id.tvNum13)
        tvNum14 = findViewById(R.id.tvNum14)
        tvNum15 = findViewById(R.id.tvNum15)

        var it = intent
        var js = JSONObject(it.getStringExtra("json"))

//        btnMeusJogos.setOnClickListener({onclickMeusJogos(it,js)})

        Log.i("jsteste",js.toString())
//
        tvConcurso.text = js.getString("numero").toString()

        tvNum1.text = js.getJSONArray("sorteio").get(0).toString()
        tvNum2.text = js.getJSONArray("sorteio").get(1).toString()
        tvNum3.text = js.getJSONArray("sorteio").get(2).toString()
        tvNum4.text = js.getJSONArray("sorteio").get(3).toString()
        tvNum5.text = js.getJSONArray("sorteio").get(4).toString()
        tvNum6.text = js.getJSONArray("sorteio").get(5).toString()
        tvNum7.text = js.getJSONArray("sorteio").get(6).toString()
        tvNum8.text = js.getJSONArray("sorteio").get(7).toString()
        tvNum9.text = js.getJSONArray("sorteio").get(8).toString()
        tvNum10.text = js.getJSONArray("sorteio").get(9).toString()
        tvNum11.text = js.getJSONArray("sorteio").get(10).toString()
        tvNum12.text = js.getJSONArray("sorteio").get(11).toString()
        tvNum13.text = js.getJSONArray("sorteio").get(12).toString()
        tvNum14.text = js.getJSONArray("sorteio").get(13).toString()
        tvNum15.text = js.getJSONArray("sorteio").get(14).toString()

    }
}
