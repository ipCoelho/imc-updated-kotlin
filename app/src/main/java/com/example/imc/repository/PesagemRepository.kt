package com.example.imc.repository

import android.app.Activity
import android.content.Context
import com.example.imc.model.Pesagem

class PesagemRepository(var context: Context) {

    fun getListaPesagem(): List<Pesagem> {
//        Criando uma lista mutável que recebe a classe Pesagem.
        val listaPesagem = mutableListOf<Pesagem>()
//        Capturando os dados do SharedPreferences, que se encontra na activity "usuario".
        val dados = context.getSharedPreferences("usuario", Context.MODE_PRIVATE);

        val pesosString = dados.getString("pesagem", "")
        val pesosArray = pesosString!!.split(";").toTypedArray()
//        90;86;99
        val datasString = dados.getString("data_pesagem", "")
        val datasArray = datasString!!.split(";").toTypedArray()
//      2021-12-06;2021-12-06;2021-12-06

        for (i in 0 until pesosArray.size) {
            val pesagem = Pesagem(datasArray[i], pesosArray[i].toInt())
            listaPesagem.add(pesagem)
        }

        return  listaPesagem
    }
}