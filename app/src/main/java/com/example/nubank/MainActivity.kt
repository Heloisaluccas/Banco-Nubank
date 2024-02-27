package com.example.nubank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtsenha = findViewById<EditText>(R.id.edtTexto)
    }
    fun btnEntrar_click(view: View) {
        val senha=findViewById<EditText>(R.id.edtTexto)
        if(senha.text.toString().toInt()=="123456".toInt()){
            val intent = Intent(this,MostrarMensagemActivity::class.java).apply {
            }
            startActivity(intent)
        }
        else {
            Toast.makeText(this, "Usuário não encontrado", Toast.LENGTH_SHORT).show()
        }
    }
}