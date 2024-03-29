package com.retos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_reto4.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class Reto4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto4)
        var resp = false

        button.setOnClickListener {
            resp = true
        }

        // Creamos un contador de 10 segundos que descuenta cada segundo.
        object : CountDownTimer(10000, 1000) {
            // Si el Temporizador termina, devolvemos true y salimos al MainActivity
            override fun onFinish() {
                resp = true
                val intent = Intent()
                intent.putExtra("resp", resp)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }

            // Si pulsamos el botón de stop, el salimos de esta activity y devolvemos un false
            override fun onTick(millisUntilFinished: Long) {

                if (resp) {
                    finish()
                } else {
                    textView2.text = (millisUntilFinished / 1000).toString()
                }
            }

        }.start()
    }
}
