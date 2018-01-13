package com.example.alexs.loterias

import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by alexs on 12/01/2018.
 */
class Lotomania{
    var numero : Int
    var data : Date
    var sorteio : ArrayList<Int>
    var ganhadores : ArrayList<Int>
    var rateio : ArrayList<Double>
    var acumulado : String
    var valor_acumulado : Double
    var cidades : ArrayList<String>
    var proxima_estimativa : Double
    var proximo_data : Date

    constructor(numero: Int, data: Date, sorteio: ArrayList<Int>, ganhadores: ArrayList<Int>, rateio: ArrayList<Double>, acumulado: String, valor_acumulado: Double, cidades: ArrayList<String>, proxima_estimativa: Double, proximo_data: Date) {
        this.numero = numero
        this.data = data
        this.sorteio = sorteio
        this.ganhadores = ganhadores
        this.rateio = rateio
        this.acumulado = acumulado
        this.valor_acumulado = valor_acumulado
        this.cidades = cidades
        this.proxima_estimativa = proxima_estimativa
        this.proximo_data = proximo_data
    }

    override fun toString(): String {
        return "Lotomania(numero=$numero, data=$data, sorteio=$sorteio, ganhadores=$ganhadores, rateio=$rateio, acumulado='$acumulado', valor_acumulado=$valor_acumulado, cidades=$cidades, proxima_estimativa=$proxima_estimativa, proximo_data=$proximo_data)"
    }


}