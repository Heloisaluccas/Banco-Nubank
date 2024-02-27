package com.example.nubank

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class MostrarPixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_pix)
        setSupportActionBar(findViewById(R.id.toolbar))
        val mensagem = intent.getStringExtra("sSaldo")
        var textView = findViewById<TextView>(R.id.saldoparapix).apply {
            text = mensagem
        }
        var saldo = mensagem
        var nsaldo = saldo.toString().toDouble()

        val btnconf = findViewById<Button>(R.id.btnConfirma)
        val edtChave = findViewById<EditText>(R.id.edtChave)
        btnconf.setOnClickListener {
            val data = Intent()
            val valorPix = findViewById<EditText>(R.id.edtValorPix)
            var nvalor = valorPix.text.toString().toDouble()
            if (nsaldo > nvalor) {
                nsaldo-=nvalor
                val txtSaldo = nsaldo.toString()
                textView.setText(txtSaldo)
                data.putExtra("sSaldo", txtSaldo)
                setResult(Activity.RESULT_OK, data)
                Toast.makeText(this, "$nsaldo", LENGTH_SHORT).show()
                valorPix.setText("".toString())
                edtChave.setText("".toString())
                finish()
            }
        }
    }
}