package com.daniel.churrascore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        GlideApp.with(this)
            .load("https://png2.kisspng.com/20180216/ddq/kisspng-churrasco-barbecue-putty-knife-download-icon-barbecue-tools-knife-and-fork-5a869a92401c62.6919958115187708342626.png")
            .placeholder(R.mipmap.ic_churrascore)
            .into(imgLogo)

        Handler().postDelayed({
            val inicio = Intent(this, InicioActivity::class.java)
            startActivity(inicio)
            finish()
        }, 2000)


    }
}
