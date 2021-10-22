package com.example.alertdialogbonus


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button=findViewById(R.id.button)

        button.setOnClickListener {
            customalert()
        }
    }

    private fun customalert(){
        val builder= AlertDialog.Builder(this@MainActivity)
     val dialogView=LayoutInflater.from(this@MainActivity).inflate(R.layout.custom_alert,null)

        builder.setView(dialogView)
        val etalert=dialogView.findViewById<EditText>(R.id.etalert)
        val tvalert=dialogView.findViewById<TextView>(R.id.tvalert)
        val bushow=dialogView.findViewById<Button>(R.id.bushow)
        val bugo=dialogView.findViewById<Button>(R.id.bugo)


            bushow.setOnClickListener {
            tvalert.text=etalert.text.toString()
        }

        bugo.setOnClickListener {
            val input=etalert.text.toString()
            val intent= Intent(this@MainActivity,MainActivity2::class.java)
            intent.putExtra("input",input)
            startActivity(intent)
        }
        builder.show()

    }
}
