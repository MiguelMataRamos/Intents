package com.example.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var texto = findViewById<TextView>(R.id.mail)
        var buscar = findViewById<EditText>(R.id.search)
        var boton = findViewById<Button>(R.id.btn)

        texto.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")

            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(texto.text.toString()))//Se puede poner un correo por defecto
            intent.putExtra(Intent.EXTRA_SUBJECT, "")//Se puede poner un asunto por defecto
            intent.putExtra(Intent.EXTRA_TEXT, "")//Se puede poner un texto por defecto

            startActivity(intent)

        }

        boton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com/search?q=${buscar.text.toString()}")

            startActivity(intent)
        }


    }
}