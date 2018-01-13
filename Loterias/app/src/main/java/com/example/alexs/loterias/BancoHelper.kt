package com.example.alexs.loterias

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by alexs on 12/01/2018.
 */
val VERSAO = 1

class BancoHelper(context: Context?) : SQLiteOpenHelper(context, "loterias.sql3", null, VERSAO) {

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table apostaLotomania(jogo integer primary key, " +
                "numero1 integer, " +
                "numero2 integer," +
                "numero3 integer," +
                "numero4 integer," +
                "numero5 integer," +
                "numero6 integer);"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table apostaLotomania")
        this.onCreate(db)
    }

}