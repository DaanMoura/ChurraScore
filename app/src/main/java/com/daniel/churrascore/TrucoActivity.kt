package com.daniel.churrascore

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.daniel.churrascore.R.id.*
import kotlinx.android.synthetic.main.activity_truco.*

class TrucoActivity : AppCompatActivity() {
    var time1selecionado = true
    var vitorias1 = 0
    var vitorias2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_truco)

        button_time1.setOnClickListener {
            time1selecionado = true
            button_time1.setBackgroundResource(R.color.timeSelecionado)
            button_time2.setBackgroundResource(R.color.timeNaoSelecionado)
        }

        button_time2.setOnClickListener {
            time1selecionado = false
            button_time2.setBackgroundResource(R.color.timeSelecionado)
            button_time1.setBackgroundResource(R.color.timeNaoSelecionado)
        }

        plus_1.setOnClickListener {
            adicionarPontos(1)
        }

        minus_1.setOnClickListener {
            adicionarPontos(-1)
        }

        plus_3.setOnClickListener {
            adicionarPontos(3)
        }

        plus_6.setOnClickListener {
            adicionarPontos(6)
        }

        plus_9.setOnClickListener {
            adicionarPontos(9)
        }

        plus_12.setOnClickListener {
            adicionarPontos(12)
        }
    }

    private fun adicionarPontos(pontos: Int) {
        val pontosAtual1 = button_time1.text.toString().toInt()
        val pontosAtual2 = button_time2.text.toString().toInt()

        if(time1selecionado) {
            if(!(pontosAtual1 + pontos < 0)) {
                button_time1.text = (pontosAtual1 + pontos).toString()
            } else Toast.makeText(this, "Pontuação não pode ser menor que zero!", Toast.LENGTH_SHORT).show()
            if(pontosAtual1 + pontos >= 12) {
                button_time1.text = 0.toString()
                vitorias1++
                txt_vitorias1.text = "Vitórias: $vitorias1"
            }
        } else {
            if(!(pontosAtual2 + pontos < 0)) {
                button_time2.text = (pontosAtual2 + pontos).toString()
            } else Toast.makeText(this, "Pontuação não pode ser menor que zero!", Toast.LENGTH_SHORT).show()
            if(pontosAtual2 + pontos >= 12) {
                button_time2.text = 0.toString()
                vitorias2++
                txt_vitorias2.text = "Vitórias: $vitorias2"
            }
        }
    }


}
