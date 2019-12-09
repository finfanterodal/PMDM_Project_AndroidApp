package com.retos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto1.*
import org.jetbrains.anko.browse

class Reto1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto1)

        //Recigemos la respuesta
        val respuesta = respuestaText.text
        //Devolvemos el valor de la respuesta y lo comparamos en el main
        bComprobar.setOnClickListener {
            val data = Intent()
            data.putExtra("respuesta", respuesta.toString())
            //devolvemos la respuesta para comparar
            setResult(Activity.RESULT_OK, data)
            finish()
        }

        // Buscamos en la url la respuesta, lanzando el navegador
        bayuda.setOnClickListener {
            browse("https://es.wikipedia.org/wiki/El_Se%C3%B1or_de_los_Anillos:_la_Comunidad_del_Anillo")
        }
    }

}
