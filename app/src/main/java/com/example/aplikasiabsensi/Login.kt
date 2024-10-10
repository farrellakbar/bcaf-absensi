package com.example.aplikasiabsensi

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class Login : AppCompatActivity() {
    private lateinit var btnLogin:Button
    private val PREF_NAME = "LOGIN"
    private val USER_IS_LOGIN = "username"
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        //START CODE
            sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE)

            val txtUsername = findViewById<EditText>(R.id.txtUsername)
            val txtPassword = findViewById<EditText>(R.id.txtPassword)

            if(sharedPreferences.contains(USER_IS_LOGIN)){
                txtUsername.setText(sharedPreferences.getString(USER_IS_LOGIN,""))
            }

            val lblBcaFinance = findViewById<TextView>(R.id.lblBcaFinance)
            lblBcaFinance.setOnClickListener{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://bcafinance.co.id"))
                startActivity(intent)
            }
            val  btnRegister = findViewById<Button>(R.id.btnRegister)
            btnRegister.setOnClickListener{
                val intent = Intent(this, Register::class.java)
                startActivity(intent)
            }
            btnLogin = findViewById(R.id.btnLogin)

            btnLogin.setOnClickListener {
                if(txtUsername.text.toString() != "")
                {
                    val editor = sharedPreferences.edit()
                    editor.putString(USER_IS_LOGIN, txtUsername.text.toString())
                    editor.apply()

                    Log.d("LoginActivity", "Button clicked")

                    Toast.makeText(this,
                        "Username : ${txtUsername.text} Password : ${txtPassword.text}",
                        Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
//                    intent.putExtra("username", txtUsername.text.toString())
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Username Tidak Boleh Kosong", Toast.LENGTH_LONG).show()
                }
            }

        //END CODE

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}