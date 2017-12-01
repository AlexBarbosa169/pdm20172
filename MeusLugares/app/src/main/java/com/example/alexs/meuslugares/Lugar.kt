package com.example.alexs.meuslugares

import android.graphics.Bitmap

/**
 * Created by alexs on 29/11/2017.
 */
class Lugar {
    var nome : String
    var descricao : String
    var latitude : Double
    var longitude : Double

    constructor(nome: String,descricao: String, latitude : Double, longitude : Double){
        this.nome = nome
        this.descricao = descricao
        this.latitude = latitude
        this.longitude = longitude

    }
}