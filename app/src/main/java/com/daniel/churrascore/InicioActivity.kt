package com.daniel.churrascore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inicio.*

class InicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        btnTruco.setOnClickListener {
            var abreTruco = Intent(this, TrucoActivity::class.java)
            startActivity(abreTruco)
        }

        btnFutebol.setOnClickListener {
            var abreFutebol = Intent(this, FutebolActivity::class.java)
            startActivity(abreFutebol)
        }

        btnPebolim.setOnClickListener {
            var abrePebolim = Intent(this, PebolimActivity::class.java)
            startActivity(abrePebolim)
        }

    }
}
