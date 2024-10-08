package com.example.aplikasiabsensi

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val PREF_NAME = "LOGIN"
    private val USER_IS_LOGIN = "username"
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var  username:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        val username = intent.getStringExtra("username")
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        username = sharedPreferences.getString(USER_IS_LOGIN,"").toString()

        val textView = findViewById<TextView>(R.id.textView3)
        textView.text = "Selamat Datang, \n$username"
        val imgProfile = findViewById<ImageView>(R.id.imgProfile)
        imgProfile.setOnClickListener{
            val implicitIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            //startActivity(implicitIntent)
            startActivityForResult(implicitIntent,99)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val crdMenuAbsensi = findViewById<CardView>(R.id.crdMenuAbsensi)

        crdMenuAbsensi.setOnClickListener {
            val intent = Intent(this, MenuAbsensi::class.java)
//            intent.putExtra("username", username)
            startActivity(intent)
        }
        val btnNotes = findViewById<androidx.cardview.widget.CardView>(R.id.crdNotes)
        btnNotes.setOnClickListener{
            val intent = Intent(this, NotesApp::class.java)
            startActivity(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==99){
            val imgProfile = findViewById<ImageView>(R.id.imgProfile)
            imgProfile.setImageBitmap(data?.extras?.get("data") as Bitmap)
        }

    }
}