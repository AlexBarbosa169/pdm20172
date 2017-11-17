package com.example.alexs.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*
import java.util.Random

/*

Jogo do arroxa!

*/

class MainActivity : AppCompatActivity() {
    lateinit var btnPalpite: Button
    lateinit var txtMin: TextView
    lateinit var txtMax: TextView
    lateinit var txtMens: TextView
    lateinit var edtPalpite: EditText
    var inicio = 1
    var fim = 99

    var random = Random()

    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }

    var arroxado = rand(1,100)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btnPalpite = findViewById(R.id.btMainPalpite)
        this.btnPalpite.setOnClickListener({ onClick(it) })

        this.txtMens = findViewById(R.id.txtMensagem)
        this.txtMin = findViewById(R.id.txtMainMin)
        this.txtMax = findViewById(R.id.txtMainMax)
        this.edtPalpite = findViewById(R.id.edtMain)

        this.txtMin.text = inicio.toString()
        this.txtMax.text = fim.toString()
    }

    fun onClick(view: View) {
        if (edtPalpite.text.toString().toInt() == arroxado) {
            txtMens.text = "Digite seu palpite"
            txtMin.text = "1"
            txtMax.text = "99"

            setMensagem("Perdeu, você foi Arroxado! Numero arroxado era: " + arroxado.toString(), "Perdeu")

        } else {
            if (edtPalpite.text.toString().toInt() < txtMin.text.toString().toInt() || edtPalpite.text.toString().toInt() > txtMax.text.toString().toInt()) {
//                txtMens.text = "Perdeu, Fora do intervalo! Intervalo era " + txtMin.text.toString() + "até " + txtMax.text.toString()
                txtMens.text = "Digite seu palpite"
                txtMin.text = "1"
                txtMax.text = "99"

                setMensagem("Perdeu, Fora do intervalo! Intervalo era " + txtMin.text.toString() + "até " + txtMax.text.toString(),"Perdeu")
            } else {
                if (edtPalpite.text.toString().toInt() == arroxado - 1) {
                    txtMens.text = "Digite seu palpite"
                    txtMin.text = "1"
                    txtMax.text = "99"

                    setMensagem("Ganhou o arroxado era : " + arroxado.toString(),"Ganhou")
                } else {
                    if (edtPalpite.text.toString().toInt() == arroxado + 1) {
                        txtMens.text = "Digite seu palpite"
                        txtMin.text = "1"
                        txtMax.text = "99"

                        setMensagem("Ganhou o arroxado era : " + arroxado.toString(),"Ganhou")
                    } else {
                        if (edtPalpite.text.toString().toInt() < arroxado) {
                            txtMens.text = "Numero e maior!"
                            txtMin.text = edtPalpite.text
                        } else {
                            if (edtPalpite.text.toString().toInt() > arroxado) {
                                txtMens.text = "Numero e menor!"
                                txtMax.text = edtPalpite.text
                            }
                        }
                    }
                }
            }
        }
    }


    fun setMensagem(mens : String , resultado : String) {
        val it = Intent(this, ResultadoActivity::class.java)
        it.putExtra("mensagem", mens)
        it.putExtra("resultado", resultado)

        startActivity(it)
    }

}



