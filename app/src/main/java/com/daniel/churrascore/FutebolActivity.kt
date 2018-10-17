package com.daniel.churrascore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_futebol.*
import java.util.*

class FutebolActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {



    var time1selecionado = true
    var time = 0L
    var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_futebol)

        fut_button_time1.setOnClickListener {
            time1selecionado = true
            fut_button_time1.setBackgroundResource(R.color.timeSelecionado)
            fut_button_time2.setBackgroundResource(R.color.timeNaoSelecionado)
        }

        fut_button_time2.setOnClickListener {
            time1selecionado = false
            fut_button_time2.setBackgroundResource(R.color.timeSelecionado)
            fut_button_time1.setBackgroundResource(R.color.timeNaoSelecionado)
        }

        fut_plus_1.setOnClickListener {
            adicionarPontos(1)
        }

        fut_minus_1.setOnClickListener {
            adicionarPontos(-1)
        }

        timer.setOnSeekBarChangeListener(this)

        play.setOnClickListener {
            if(!isRunning) {
                countdown(time, 1000).start()
                isRunning = true
            }
        }

        pause.setOnClickListener {
            isRunning = false
            Log.d("Log", "Pause")
        }
    }

    private fun adicionarPontos(pontos: Int) {
        val pontosAtual1 = fut_button_time1.text.toString().toInt()
        val pontosAtual2 = fut_button_time2.text.toString().toInt()
        if(time1selecionado) {
            if(!(pontosAtual1 + pontos < 0)) {
                fut_button_time1.text = (pontosAtual1 + pontos).toString()
            } else Toast.makeText(this, "Pontuação não pode ser menor que zero!", Toast.LENGTH_SHORT).show()
        } else {
            if(!(pontosAtual2 + pontos < 0)) {
                fut_button_time2.text = (pontosAtual2 + pontos).toString()
            } else Toast.makeText(this, "Pontuação não pode ser menor que zero!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        if(!isRunning) {
            time = (p1 * 30000).toLong()
            val min = (time / 1000) / 60
            val sec = (time / 1000) % 60

            tempo.text = "$min : $sec    $time"
        }
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
        isRunning = false
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }

    private fun countdown(millisInFuture:Long,countDownInterval:Long):CountDownTimer{
        return object: CountDownTimer(millisInFuture,countDownInterval){
            override fun onTick(millisUntilFinished: Long){
                if(isRunning) {
                    val min = (millisUntilFinished / 1000) / 60
                    val sec = (millisUntilFinished / 1000) % 60
                    time = time - 1000
                    tempo.text = "$min : $sec    $time"
                } else cancel()
            }

            override fun onFinish() {

            }
        }
    }



}
