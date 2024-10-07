package com.example.aplikasiabsensi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Register : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var buttonSave: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Inisialisasi EditText dan Button
        editTextName = findViewById(R.id.txtNameRegister)
        editTextPassword = findViewById(R.id.txtPasswordRegister)
        editTextEmail = findViewById(R.id.txtEmailRegister)
        editTextAddress = findViewById(R.id.txtAddressRegister)
        buttonSave = findViewById(R.id.btnSaveRegister)
        textResult = findViewById(R.id.txtResult)

        // Set OnClickListener untuk buttonSave
        buttonSave.setOnClickListener {
            // Ambil nilai dari setiap EditText
            val name = editTextName.text.toString()
            val password = editTextPassword.text.toString()
            val email = editTextEmail.text.toString()
            val address = editTextAddress.text.toString()

            // Gabungkan hasil input ke dalam satu string
            val resultText = """
                Name: $name
                Password: $password
                Email: $email
                Address: $address
            """.trimIndent()

            // Tampilkan hasil di TextView
            textResult.text = resultText
        }
    }
}