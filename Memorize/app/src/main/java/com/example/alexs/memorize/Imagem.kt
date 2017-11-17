package com.example.alexs.memorize

/**
 * Created by alexs on 09/11/2017.
 */

class Imagem (private var descricao : String, private var caminho : String){

    fun adicionarDescricao(nova_descricao: String) {
        this.descricao = nova_descricao
    }

    fun adicionarCaminho(novo_caminho : String){
        this.caminho = novo_caminho
    }

}