package com.example.nubank

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MostrarDepositoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_deposito)
        setSupportActionBar(findViewById(R.id.tbDep))
        val btnConf = findViewById<Button>(R.id.btnDep)
        val txtsaldo = intent.getStringExtra("sSaldo")
        var nsaldo = txtsaldo.toString().toDouble()
        var senha = 1234

        btnConf.setOnClickListener {
            val data = Intent()
            val edtValorDepositar = findViewById<EditText>(R.id.edtvalor)
            val edtContaDep = findViewById<EditText>(R.id.edtNumConta)
            val edtAgencia = findViewById<EditText>(R.id.edtAg)
            val edtsenha = findViewById<EditText>(R.id.edtsenha)
            val edtsenhaN = edtsenha.text.toString().toInt()
            val nValor = edtValorDepositar.text.toString().toDouble()
            if (senha==edtsenhaN){
                if (nsaldo < nValor) {
                    Toast.makeText(this, "Saldo de $nsaldo é insuficiente", Toast.LENGTH_SHORT).show()
                } else {
                    nsaldo += nValor
                }
                val txtSaldo = nsaldo.toString()
                data.putExtra("sSaldo",txtSaldo)
                setResult(Activity.RESULT_OK,data)
                Toast.makeText(this,"$nsaldo", Toast.LENGTH_SHORT).show()
                edtValorDepositar.setText("".toString())
                finish()

            }else {
                Toast.makeText(this, "Senha Incorreta!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
