package com.example.alexs.memorize

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_tabuleiro.*

class TabuleiroActivity : AppCompatActivity() {
    lateinit var txtRes : TextView
    lateinit var send : Button
    lateinit var tabulerio : GridLayout
    lateinit var imagem1 : ImageView
    lateinit var imagem2 : ImageView
    lateinit var imagem3 : ImageView
    lateinit var imagem4 : ImageView
    lateinit var imagem5 : ImageView
    lateinit var imagem6 : ImageView
    lateinit var imagem7 : ImageView
    lateinit var imagem8 : ImageView
    var imagemS1 : ImageView? = null
    var imagemS2 : ImageView? = null

    var img1 : String? = null
    var idImg1 : Int? = null
    var img2 : String? = null
    var idImg2 : Int? = null

    var letras = listOf("a","b","d","c","b","a","c","d")
    var acertos = mutableListOf<String>()
    var imagens = hashMapOf<Int,ImageView>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabuleiro)
        this.txtRes = findViewById(R.id.resultado)
        this.send = findViewById(R.id.btnSend)
        this.tabulerio = findViewById(R.id.gdTabuleiro)
        this.imagem1 = findViewById(R.id.img1)
        this.imagem2 = findViewById(R.id.img2)
        this.imagem3 = findViewById(R.id.img3)
        this.imagem4 = findViewById(R.id.img4)
        this.imagem5 = findViewById(R.id.img5)
        this.imagem6 = findViewById(R.id.img6)
        this.imagem7 = findViewById(R.id.img7)
        this.imagem8 = findViewById(R.id.img8)

//        println(imagem1.layoutParams)

//        for(t in  tabulerio){
//
//        }

        imagens.put(1,imagem1)
        imagens.put(2,imagem2)
        imagens.put(3,imagem3)
        imagens.put(4,imagem4)
        imagens.put(5,imagem5)
        imagens.put(6,imagem6)
        imagens.put(7,imagem7)
        imagens.put(8,imagem8)

        for(i in 1 .. 8){
            imagens.get(i)?.setOnClickListener({click(it as ImageView, i)})
        }

        send.setOnClickListener({send(it as Button)})



//        var i = 1
//        for(l in letras){
//
//            ordem.put(i++,l)
//        }
//
//        for (o in ordem){
//        println(o)
//        }
//        println(imagem1.top)
//        imagem1.setOnClickListener({click(it as ImageView)})
//        imagem2.setOnClickListener({click(it as ImageView)})
//        imagem3.setOnClickListener({click(it as ImageView)})
//        imagem4.setOnClickListener({click(it as ImageView)})
//        imagem5.setOnClickListener({click(it as ImageView)})
//        imagem6.setOnClickListener({click(it as ImageView)})
//        imagem7.setOnClickListener({click(it as ImageView)})
//        imagem8.setOnClickListener({click(it as ImageView)})



//        this.imagem = findViewById(R.id.img1)
//        imagem.setImageDrawable(getDrawable(R.drawable.login))

    }

    fun click(view: ImageView, id : Int){
        var im = letras.get(id-1)
        if(!acertos.contains(im)){
            if(img1 == null){
                img1 = im
                idImg1 = id
                imagemS1 = view
                view.setImageDrawable(drowables(im))
                println("Imagem 1: "+ img1)
                println("Imagem 1: "+ img2)
            }else{
                if(img2 == null){
                    img2 = im
                    idImg2 = id
                    imagemS2 = view
                    view.setImageDrawable(drowables(im))
                    println("Imagem 1: "+ img1)
                    println("Imagem 1: "+ img2)
                }
            }
        }

    }

    fun send(view: Button){
        if(img2 != null && img1 != null){
            if(img1.equals(img2)){
                resultado.text = "Acertou, a mizéravi!"
                acertos.add(img1.toString())
                img1 = null
                img2 = null
                if (acertos.size > 3){
                    resultado.text = "Você Ganhou!"
                }
            }else{
                resultado.text = "Errou!!"
                imagemS1!!.setImageDrawable(getDrawable(R.drawable.login))
                imagemS2!!.setImageDrawable(getDrawable(R.drawable.login))
                img1 = null
                img2 = null
            }
        }
    }

    fun drowables(s : String) : Drawable? {
        var drow : Drawable? = null
        when (s) {
            "a" -> {drow = getDrawable(R.drawable.a)}
            "b" -> {drow = getDrawable(R.drawable.b)}
            "c" -> {drow = getDrawable(R.drawable.c)}
            "d" -> {drow = getDrawable(R.drawable.d)}
            "" -> { // Note the block
                print("x is neither 1 nor 2")

            }
        }
        return drow
    }

}
