package com.example.alexs.loterias

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView

class MeusJogos2Activity : AppCompatActivity() {

    lateinit var lista : ListView
    lateinit var daoApostaLotomania : ApostaLotomaniaDAO
    var nomes = arrayListOf<String>("Thalita", "Gilberto", "Alex", "Júnior", "Lucas", "Raimundo", "Mateus")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meus_jogos2)

        this.daoApostaLotomania = ApostaLotomaniaDAO(this)
//        var aposta = ApostaMegaSena(1,2003,1,1,1,3,4,5,6)
//        this.dao.insert(aposta)
//        var resultados = dao.select()
//        for (ap : ApostaMegaSena in resultados){
//            Log.i("resultados", ap.toString())
//        }
        lista = findViewById(R.id.lista)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes)
        this.lista.adapter = adapter

        this.lista.setOnItemClickListener({parent, view, position, id ->
            Log.i("APP", this.nomes[position])
        })

        // click longo
        this.lista.setOnItemLongClickListener({parent, view, position, id ->
            insere()
            true
        })


    }

    fun insere(){
//        val aposta = ApostaLotomania(1111,1,2,3,4,5,6)
//
//        Log.i("aposta", aposta.toString())
//        this.daoApostaLotomania.insert(aposta)
        this.daoApostaLotomania.delete(1111)
        Log.i("TesteIns", "Apagou!")
        Log.i("jogosalvo", this.daoApostaLotomania.select().size.toString())

    }
}
