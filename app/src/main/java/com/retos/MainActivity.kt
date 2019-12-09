package com.retos

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

const val RETO1_REQUEST = 1
const val RETO2_REQUEST = 2
const val RETO3_REQUEST = 3
const val RETO4_REQUEST = 4

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Lanzamos otra Activity en la que hay una serie de preguntas y tienes opción a buscar en el navegador .*/
        reto1.setOnClickListener {
            val intent = Intent(this, Reto1::class.java)
            startActivityForResult(intent, RETO1_REQUEST)//iniciamos
        }

        /*Lanzamos la cámara y sacamos una foto sobre algo y verificamos.*/
        reto2.setOnClickListener {
            val intent2 = Intent(this, Reto2::class.java)
            startActivityForResult(intent2, RETO2_REQUEST)
        }

        /*Lanzamos otra Activity en la que pedimos hacer un cálculo y verifica,mps.*/
        reto3.setOnClickListener {

        }


        reto4.setOnClickListener {

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // RESULTADO RETO1
        if (requestCode == RETO1_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                if ((data?.getStringExtra("respuesta").toString()).equals("2001")) {
                    reto1.setBackgroundColor(Color.GREEN)//boton verde= acierto

                } else {
                    reto1.setBackgroundColor(Color.RED)//boton rojo= error
                }
            }
            reto1.setEnabled(false)//desactivamos el reto, ya se ha realizado
        }
        // RESULTADO RETO2

        //Reto2

        if (requestCode == RETO2_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                if (data?.getBooleanExtra("resp", false)!!.equals(true)) {
                    reto2.setBackgroundColor(Color.GREEN)//boton verde= acierto
                    toast("CORRECTO")
                } else {
                    reto2.setBackgroundColor(Color.RED)//boton rojo= error
                    toast("INCORRECTO")
                }
            }
            reto2.setEnabled(false)//desactivamos el reto, ya se ha realizado
        }


        // RESULTADO RETO3

        // RESULTADO RETO4

    }
}
