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

        /*Lanzamos otra Activity en la que hay una pregunta y tienes opción a buscar en el navegador .*/
        reto1.setOnClickListener {
            val intent = Intent(this, Reto1::class.java)
            startActivityForResult(intent, RETO1_REQUEST)//iniciamos
        }

        /*Lanzamos la cámara, pedimos que pulse un botón que selecciona un color al azar, y tendremos que sacar una foto de ese color.*/
        reto2.setOnClickListener {
            val intent2 = Intent(this, Reto2::class.java)
            startActivityForResult(intent2, RETO2_REQUEST)
        }

        /*Lanzamos otra Activity en la que pedimos hacer un cálculo y verifica la respuesta.*/
        reto3.setOnClickListener {
            val intent3 = Intent(this, Reto3::class.java)
            startActivityForResult(intent3, RETO3_REQUEST)
        }

        /*Lanzamos otra Activity en la que se ejecuta un temporizador, si pulsamos stop, perdemos y devolvemos un false.*/
        reto4.setOnClickListener {
            val intent4 = Intent(this, Reto4::class.java)
            startActivityForResult(intent4, RETO4_REQUEST)
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

        if (requestCode == RETO3_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                reto3.setBackgroundColor(Color.GREEN)//boton verde= acierto
                toast("CORRECTO")

            } else {
                reto3.setBackgroundColor(Color.RED)//boton rojo= error
                toast("INCORRECTO")
            }
            reto3.setEnabled(false)//desactivamos el reto, ya se ha realizado
        }

        // RESULTADO RETO4
        if (requestCode == RETO4_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                reto4.setBackgroundColor(Color.GREEN)//boton verde= acierto
            } else {
                reto4.setBackgroundColor(Color.RED)//boton rojo= error
            }
            reto4.setEnabled(false)//desactivamos el reto, ya se ha realizado
        }
    }
}
