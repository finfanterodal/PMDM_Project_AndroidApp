package com.retos

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_reto2.*
import org.jetbrains.anko.toast
import kotlin.random.Random


class Reto2 : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1
    var resultadoR = false
    var resultadoV = false
    var resultadoA = false
    var rojo = false
    var azul = false
    var verde = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto2)

        // Pedimos permisos y guardamos la captura
        bCamara.setOnClickListener {

            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CAMERA
                )
                != PackageManager.PERMISSION_GRANTED
            ) {

                // Permission is not granted
                toast("No tiene este permiso para acceder a la Camara.")

                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.CAMERA
                    )
                ) {

                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.CAMERA),
                        REQUEST_IMAGE_CAPTURE
                    )
                }
            } else {
                Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                    takePictureIntent.resolveActivity(packageManager)?.also {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                    }
                }
                toast("Ya tiene este permiso.")
            }


        }

        // Devolvemos al main un true si alguno de los colores coincide
        bComprobar.setOnClickListener {
            val data = Intent()

            //devolvemos la respuesta para comparar
            if (rojo && resultadoR) {
                data.putExtra("resp", true)
            } else if (verde && resultadoV) {
                data.putExtra("resp", true)
            } else if (azul && resultadoA) {
                data.putExtra("resp", true)
            }
            data.putExtra("resp", false)
            setResult(Activity.RESULT_OK, data)
            finish()
        }


        // Color a fotografiar, se genera un numero que decide el color
        bColor.setOnClickListener {
            var valor = Random.nextInt(1, 3)
            when (valor) {
                1 -> {
                    rojo = true
                    verde = false
                    azul = false
                    bColor.setBackgroundColor(Color.RED)
                }
                2 -> {
                    azul = true
                    rojo = false
                    verde = false
                    bColor.setBackgroundColor(Color.BLUE)
                }
                3 -> {
                    verde = true
                    rojo = false
                    azul = false
                    bColor.setBackgroundColor(Color.GREEN)
                }
                else -> println("No existe.")
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)

            // recojo el color del pixel central
            val colorCentro = imageBitmap.getPixel(imageBitmap.width / 2, imageBitmap.height / 2)
            val red = colorCentro shr 16 and 0xff
            val green = colorCentro shr 8 and 0xff
            val blue = colorCentro and 0xff

            // Comparamos si el color y la variable color coinciden
            if (red > 100 && green < 60 && blue < 60 && rojo) {
                resultadoR = true
            } else if (red > 60 && green < 100 && blue < 60 && verde) {
                resultadoV = true
            } else if (red > 60 && green < 60 && blue < 100 && azul) {
                resultadoA = true
            }
        }
    }


}
