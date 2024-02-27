package com.example.nubank

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.selects.SelectInstance

class MostrarMensagemActivity : AppCompatActivity() {
    val COD_TELA=2
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_mensagem)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == COD_TELA && resultCode == Activity.RESULT_OK){
            val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
            val sSaldo = data !!.getStringExtra("sSaldo")
            txtSaldo.setText(sSaldo)
        }
    }
    fun btnpix_click(view: View) {
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent(this, MostrarPixActivity::class.java).apply{
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }
    fun btntrans_click(view: View) {
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent(this, MostrarTransferenciaActivity::class.java).apply{
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }

    fun btndep_click (view: View){
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent(this, MostrarDepositoActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }
}



