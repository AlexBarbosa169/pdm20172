package com.example.alexs.meuslugares

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var textoMain : TextView
    lateinit var botaoMain : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textoMain = findViewById(R.id.txtMain)
        botaoMain = findViewById(R.id.btnMain)

        botaoMain.setOnClickListener({adicionarLocal(it)})
    }

    fun adicionarLocal(btn: View){
        val it = Intent(this,Lugares2Activity::class.java)
        startActivityForResult(it,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                var primeiro = data?.getStringExtra("primeiro")
                Toast.makeText(this, primeiro, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
