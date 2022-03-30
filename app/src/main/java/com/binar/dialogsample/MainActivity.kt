package com.binar.dialogsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var alertDialogStandar: Button
    private lateinit var alertDialogTombolAksi: Button
    private lateinit var alertDialogCustomLayout: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alertDialogStandar = findViewById(R.id.dialog_standar)
        alertDialogTombolAksi= findViewById(R.id.dialog_tombol_aksi)
        alertDialogCustomLayout = findViewById(R.id.dialog_custom)


        alertDialogStandar.setOnClickListener {
            alertDialogStandar()
        }
        alertDialogTombolAksi.setOnClickListener {
            alertDialogTombolAksi()
        }
        alertDialogCustomLayout.setOnClickListener {
            alertDialogCustom()
        }

    }
    private fun alertDialogStandar() {
        //Alert Dialog Standar
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog Cancelable")
        dialog.setMessage("Dialog Cancelable bisa ditutup dengan klik bagian luar dialog")
        dialog.setCancelable(true)
        dialog.show()
    }
    private fun alertDialogTombolAksi() {
        //Alert Dialog dengan Tombol Aksi
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Penyemangat")
        dialog.setMessage("Selamat Datang di Ruang Penyemangat Pilih Aksi Anda")
        dialog.setIcon(R.mipmap.ic_launcher)

        dialog.setCancelable(false) //agar ketika diklik tidak langsung keluar
        dialog.setPositiveButton("Aku ingin Disemangati"){dialogInterface, p1 ->
            Toast.makeText(this,"Anda akan Disemnagati", Toast.LENGTH_LONG).show()
        }
        dialog.setNegativeButton("Aku tidak Butuh Disemangati"){dialogInterface, p1 ->
            Toast.makeText(this, "Anda tidak akan Disemngati", Toast.LENGTH_LONG).show()
        }
        dialog.setNeutralButton("Aku sendang Baik Saja"){dialogInterface, p1 ->
            Toast.makeText(this, "Anda Baik Baik saja", Toast.LENGTH_LONG).show()
        }
        dialog.show()
    }
    private fun alertDialogCustom() {
        // Alert Dialog dengan Custom Layout
        val view = LayoutInflater.from(this).inflate(androidx.core.R.layout.custom_dialog,null,false)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(view)

        val dialog = dialogBuilder.create()

        view.setOnClickListener {
            Toast.makeText(this, "Close", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dialog.show()
    }

}