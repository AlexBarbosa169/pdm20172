package com.example.alexs.loterias

/**
 * Created by alexs on 15/01/2018.
 */
class ApostaMegaSena {
    var jogo : Int
    var consursoInicial : Int
    var quantidadeConcursos : Int
    var numero1 : Int = 0
    var numero2 : Int = 0
    var numero3 : Int = 0
    var numero4 : Int = 0
    var numero5 : Int = 0
    var numero6 : Int = 0

    constructor(jogo: Int, consursoInicial: Int, quantidadeConcursos: Int, numero1: Int, numero2: Int, numero3: Int, numero4: Int, numero5: Int, numero6: Int) {
        this.jogo = jogo
        this.consursoInicial = consursoInicial
        this.quantidadeConcursos = quantidadeConcursos
        this.numero1 = numero1
        this.numero2 = numero2
        this.numero3 = numero3
        this.numero4 = numero4
        this.numero5 = numero5
        this.numero6 = numero6
    }

    fun getConcurso(): Int {
        return consursoInicial
    }

    fun getConcursos(): Int {
        return quantidadeConcursos
    }

    fun getNumeros(): ArrayList<Int> {
        var array = arrayListOf<Int>()

        array.add(this.numero1)
        array.add(this.numero2)
        array.add(this.numero3)
        array.add(this.numero4)
        array.add(this.numero5)
        array.add(this.numero6)

        return array
    }

}