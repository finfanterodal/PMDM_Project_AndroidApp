package com.retos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto3.*

class Reto3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto3)

        bComprobar.setOnClickListener {
            var calculo = 17
            var respuesta = Integer.parseInt(textNumber.text.toString())

            if (calculo == respuesta) {
                var resp = true
                val intent = Intent()
                intent.putExtra("resp", resp)
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                finish()
            }
        }
    }
}
