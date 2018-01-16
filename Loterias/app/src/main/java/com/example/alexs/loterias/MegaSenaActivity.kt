package com.example.alexs.loterias

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject

class MegaSenaActivity : AppCompatActivity() {

    lateinit var tvConcurso : TextView
    lateinit var tvNum1 : TextView
    lateinit var tvNum2 : TextView
    lateinit var tvNum3 : TextView
    lateinit var tvNum4 : TextView
    lateinit var tvNum5 : TextView
    lateinit var tvNum6 : TextView
    lateinit var tvSena : TextView
    lateinit var tvQuina : TextView
    lateinit var tvQuadra : TextView
    lateinit var tvPremioSena : TextView
    lateinit var tvPremioQuina : TextView
    lateinit var tvPremioQuadra : TextView
    lateinit var btnDetalhes : Button
    lateinit var btnMeusJogos : Button
    lateinit var itt : Intent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mega_sena)

        tvConcurso = findViewById(R.id.tvConcursoNum)
        tvNum1 = findViewById(R.id.tvNum1)
        tvNum2 = findViewById(R.id.tvNum2)
        tvNum3 = findViewById(R.id.tvNum3)
        tvNum4 = findViewById(R.id.tvNum4)
        tvNum5 = findViewById(R.id.tvNum5)
        tvNum6 = findViewById(R.id.tvNum6)
        tvSena = findViewById(R.id.tvSena)
        tvQuina = findViewById(R.id.tvQuina)
        tvQuadra = findViewById(R.id.tvQuadra)
        tvPremioSena = findViewById(R.id.tvPremioSena)
        tvPremioQuina = findViewById(R.id.tvPremioQuina)
        tvPremioQuadra = findViewById(R.id.tvPremioQuadra)
        btnMeusJogos = findViewById(R.id.btnMeusJogos)



        var it = intent
        var js = JSONObject(it.getStringExtra("json"))

//        btnDetalhes.setOnClickListener({onclickDetalhes(it)})
        btnMeusJogos.setOnClickListener({onclickMeusJogos(it,js)})

        Log.i("jsteste",js.toString())

        tvConcurso.text = js.getString("numero").toString()

        tvNum1.text = js.getJSONArray("sorteio").get(0).toString()
        tvNum2.text = js.getJSONArray("sorteio").get(1).toString()
        tvNum3.text = js.getJSONArray("sorteio").get(2).toString()
        tvNum4.text = js.getJSONArray("sorteio").get(3).toString()
        tvNum5.text = js.getJSONArray("sorteio").get(4).toString()
        tvNum6.text = js.getJSONArray("sorteio").get(5).toString()
        tvSena.text = js.getJSONArray("ganhadores").get(0).toString()
        tvQuina.text = js.getJSONArray("ganhadores").get(1).toString()
        tvQuadra.text = js.getJSONArray("ganhadores").get(2).toString()
        tvPremioSena.text = js.getJSONArray("rateio").get(0).toString()
        tvPremioQuina.text = js.getJSONArray("rateio").get(1).toString()
        tvPremioQuadra.text = js.getJSONArray("rateio").get(2).toString()

    }

    fun onclickDetalhes(view: View){

    }

    fun onclickMeusJogos(view: View, js : JSONObject){
        Log.i("clique", "Clicou!")
        var it = Intent(this@MegaSenaActivity,MeusJogos2Activity::class.java)
        it.putExtra("sorteioAtual",js.getString("numero").toString())
        startActivity(it)
    }
}
