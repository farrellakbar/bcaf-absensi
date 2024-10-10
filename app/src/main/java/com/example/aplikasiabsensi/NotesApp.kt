package com.example.aplikasiabsensi

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentActivity
import com.example.aplikasiabsensi.fragment.ListFragment
import com.example.aplikasiabsensi.fragment.NotesFragment
import com.example.aplikasiabsensi.model.Notes

class NotesApp : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notes_app)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if(resources.configuration.orientation==Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction().setReorderingAllowed(true)
            supportFragmentManager.beginTransaction().replace(R.id.frameListNotes, ListFragment()).commit()

            if(supportFragmentManager.findFragmentById(R.id.frameNotes)!=null){
                supportFragmentManager.beginTransaction().remove(supportFragmentManager.findFragmentById(R.id.frameNotes)!!).commit()
            }




//            val notes = Notes("Catatan Si Boy", "Ini catatannya")
//            notes.apply {
//                title = "Catatan Si Boy"
//                isi = "Ini catatannya"
//            }

        }else{
//            supportFragmentManager.beginTransaction().replace(R.id.frameListNotes, ListFragment())
//                .commit()
//            supportFragmentManager.beginTransaction().replace(R.id.frameNotes, NotesFragment())
//                .commit()

            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)

                replace(R.id.frameListNotes, ListFragment())
                replace(R.id.frameNotes, NotesFragment())
            }.commit()



        }

    }
}