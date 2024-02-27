package com.example.nubank

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MostrarTransferenciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_transferencia)
        setSupportActionBar(findViewById(R.id.tbTrans))
        val conf = findViewById<Button>(R.id.btnConf)
        val txtsaldo = intent.getStringExtra("sSaldo")
        var nsaldo = txtsaldo.toString().toDouble()
        var senha = 1234

        conf.setOnClickListener {
            val data = Intent()
            val edtConta = findViewById<EditText>(R.id.edtConta)
            val edtAgencia = findViewById<EditText>(R.id.edtNumAgencia)
            val edtsenha = findViewById<EditText>(R.id.edtsenha)
            val edtsenhaN = edtsenha.text.toString().toInt()
            val edtValor = findViewById<EditText>(R.id.edtValorT)
            val nValor = edtValor.text.toString().toDouble()
            if (senha==edtsenhaN){
                if(nsaldo<nValor) {
                    Toast.makeText(this, "Saldo de $nsaldo é insuficiente", Toast.LENGTH_SHORT).show()
                }
                else {
                    nsaldo -= nValor
                }
                val txtSaldo = nsaldo.toString()
                data.putExtra("sSaldo",txtSaldo)
                setResult(Activity.RESULT_OK,data)
                Toast.makeText(this,"$nsaldo", Toast.LENGTH_SHORT).show()
                edtConta.setText("".toString())
                edtAgencia.setText("".toString())
                edtValor.setText("".toString())
                finish()
            }else {
                Toast.makeText(this, "Senha Incorreta!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

