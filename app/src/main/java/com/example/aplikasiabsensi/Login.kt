package com.example.aplikasiabsensi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class Login : AppCompatActivity() {
    private lateinit var btnLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        //START CODE
            val txtUsername = findViewById<EditText>(R.id.txtUsername)
            val txtPassword = findViewById<EditText>(R.id.txtPassword)

            btnLogin = findViewById(R.id.btnLogin)

            btnLogin.setOnClickListener {
                Log.d("LoginActivity", "Button clicked")

                Toast.makeText(this,
                                "Username : ${txtUsername.text} Password : ${txtPassword.text}",
                                Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", txtUsername.text.toString())
                startActivity(intent)
            }

        //END CODE

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}