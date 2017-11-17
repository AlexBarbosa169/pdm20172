package com.example.alexs.memorize

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var imagens : Imagem
    lateinit var btnMainClick : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btnMainClick = findViewById(R.id.btnMainVai)

        btnMainClick.setOnClickListener({ onClick(it)})
    }

    fun onClick(view : View){
        val it = Intent(this, TabuleiroActivity::class.java)
        //startActivity(it)
        startActivity(it)
    }
}

