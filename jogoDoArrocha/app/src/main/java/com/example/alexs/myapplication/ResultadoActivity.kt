package com.example.alexs.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
        lateinit var btnResVoltar : Button
        lateinit var txtResText : TextView
        lateinit var linearLay : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        this.linearLay = findViewById(R.id.linearMensResult)

        this.txtResText = findViewById(R.id.txtResView)
        this.txtResText.text = intent.getStringExtra("mensagem")

        this.btnResVoltar = findViewById(R.id.btnRespVoltar)
        this.btnResVoltar.setOnClickListener({onClick(it)})

        if(intent.getStringExtra("resultado").equals("Perdeu")){
            linearLay.setBackgroundColor(Color.RED)}
        else{
            linearLay.setBackgroundColor(Color.GREEN)}

    }

    fun onClick(view: View){
        val it = Intent()
//        it.putExtra("MSN", "Funciona mesmo!")
//        setResult(Activity.RESULT_OK, it)
        finish()
    }

}
