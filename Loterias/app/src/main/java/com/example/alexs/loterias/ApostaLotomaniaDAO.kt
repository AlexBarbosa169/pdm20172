package com.example.alexs.loterias

import android.content.ContentValues
import android.content.Context
import android.util.Log

/**
 * Created by alexs on 12/01/2018.
 */
class ApostaLotomaniaDAO {
    lateinit var bancoHelper: BancoHelper
    val TABELA = "apostaLotomania"

    constructor(contexto: Context){
        this.bancoHelper = BancoHelper(contexto)
    }

    fun insert(ap: ApostaLotomania){
        val banco = this.bancoHelper.writableDatabase // SQLiteDabatase
        val cv = ContentValues()
        cv.put("jogo", ap.jogo)
        cv.put("numero1", ap.numero1)
        cv.put("numero2", ap.numero2)
        cv.put("numero3", ap.numero3)
        cv.put("numero4", ap.numero4)
        cv.put("numero5", ap.numero5)
        cv.put("numero6", ap.numero6)
        banco.insert(TABELA, null, cv)
    }

    fun select(): List<ApostaLotomania>{
        val lista = arrayListOf<ApostaLotomania>()
        val banco = this.bancoHelper.readableDatabase
        val colunas = arrayOf("jogo", "numero1","numero2","numero3","numero4","numero5","numero6")
        val c = banco.query(TABELA, colunas, null, null, null, null, null)

        c.moveToFirst()

        do{
            // recuperar id, nome, idade
            val jogo = c.getInt(c.getColumnIndex("jogo"))
            val num1 = c.getInt(c.getColumnIndex("numero1"))
            val num2 = c.getInt(c.getColumnIndex("numero2"))
            val num3 = c.getInt(c.getColumnIndex("numero3"))
            val num4 = c.getInt(c.getColumnIndex("numero4"))
            val num5 = c.getInt(c.getColumnIndex("numero5"))
            val num6 = c.getInt(c.getColumnIndex("numero6"))

            // instanciar uma pessoa
            val p = ApostaLotomania(jogo,num1, num2,num3,num4,num5,num6)
            Log.i("APP", p.toString())

            // add pessoa na lista
            lista.add(p)
        }while(c.moveToNext())

        return lista
    }

    fun delete(id: Int){
        val banco = this.bancoHelper.readableDatabase
        banco.delete(TABELA,null,null)
        banco.close()
        Log.i("Operacao","Apagou!")
    }

    fun update(p: ApostaLotomania){

    }
}