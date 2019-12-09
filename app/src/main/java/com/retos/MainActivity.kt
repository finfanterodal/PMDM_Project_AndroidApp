package com.retos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

const val RETO1_REQUEST = 1
const val RETO2_REQUEST = 2
const val RETO3_REQUEST = 3
const val RETO4_REQUEST = 4

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Listenners
        reto1.setOnClickListener { reto1_Pregunta(it) }
        reto2.setOnClickListener { reto2_Camara(it) }
        reto3.setOnClickListener { reto3_Calculadora(it) }
        reto4.setOnClickListener { reto4_Sorpresa(it) }
    }
    /*Lanzamos otra Activity en la que hay una serie de preguntas y tienes opción a buscar en el navegador (Añadimos un temporizador).*/
    fun reto1_Pregunta(v: View) {

    }

    /*Lanzamos la cámara y sacamos una foto sobre algo y verificamos.*/
    fun reto2_Camara(v: View) {
    }

    /*Lanzamos otra Activity en la que pedimos un par de números y hacemos un cálculo.*/
    fun reto3_Calculadora(v: View) {

    }

    /*Sorpresa*/
    fun reto4_Sorpresa(v: View) {

    }
}
