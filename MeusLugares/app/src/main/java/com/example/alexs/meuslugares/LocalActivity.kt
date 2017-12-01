package com.example.alexs.meuslugares

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class LocalActivity : AppCompatActivity() {
    lateinit var imgView : ImageView
    lateinit var txtLocal : TextView
    lateinit var txtDescricao : TextView
    lateinit var extra : Bundle
    lateinit var btnVoltar : Button
    lateinit var txtLongitude : TextView
    lateinit var txtLatitude : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local)

        imgView = findViewById(R.id.imgLocal)
        txtLocal = findViewById(R.id.txtLocalId)
        btnVoltar = findViewById(R.id.btnVoltar)
        txtDescricao = findViewById(R.id.txtLocalDesc)
        btnVoltar.setOnClickListener({onClick(it)})
        txtLatitude = findViewById(R.id.txtLocalLatitude)
        txtLongitude = findViewById(R.id.txtLocalLongitde)

        extra = intent.getExtras()
        var imagem = extra.get("imagem")
        var nome = extra.get("nome") as String
        var descricao = extra.get("descricao") as String
        var latitude = extra.get("latitude")
        txtLatitude.text = latitude as String
        var longitude = extra.get("longitude")
        txtLongitude.text = longitude as String
        txtLocal.text = nome
        txtDescricao.text = descricao
        imgView.setImageBitmap(imagem as Bitmap);

    }

    fun onClick(view: View) {
        finish()
    }
}
