package com.example.aplikasiabsensi.fragment

import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.aplikasiabsensi.R
import com.example.aplikasiabsensi.model.Notes

class NotesFragment: Fragment() {
    lateinit var sharedPreferences: SharedPreferences
    val PREF_NAME = "Notes"
//    val KEY_NOTES = "judul"
    lateinit var txtNotes: EditText
    lateinit var txtJudulNotes: EditText
    lateinit var btnSaveNotes: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notes, container, false)

        txtNotes = view.findViewById(R.id.txtNotes)
        btnSaveNotes = view.findViewById(R.id.btnSaveNotes)
        txtJudulNotes = view.findViewById(R.id.txtJudulNotes)

        arguments?.getParcelable<Notes>("notes")?.let {
            txtNotes.setText(it.isi)
            txtJudulNotes.setText(it.judul)
        }

        btnSaveNotes.setOnClickListener{
            saveNotes(txtJudulNotes.text.toString(), txtNotes.text.toString())
//            txtNotes.setText("")
//            txtJudulNotes.setText
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frameListNotes, ListFragment()).commit()
            }
            else {
//                val listFragment = parentFragmentManager.findFragmentById(R.id.frameListNotes) as ListFragment
//                if(listFragment!=null){
//                    listFragment.updateDataSharedPreference(Notes(txtJudulNotes.text.toString(),txtNotes.text.toString()))
//
//                    txtNotes.setText("")
//                    txtJudulNotes.setText("")
//                }
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frameListNotes, ListFragment()).commit()


                txtNotes.setText("")
                txtJudulNotes.setText("")
            }
        }
        return view
    }

    fun saveNotes(judul: String, isi: String){
        sharedPreferences = requireActivity().getSharedPreferences(PREF_NAME,0)
        val editor = sharedPreferences.edit()
        editor.putString(judul,isi)
        editor.apply()
    }

    fun loadNotes(judul: String): String {
        sharedPreferences = requireActivity().getSharedPreferences(PREF_NAME, 0)
        return sharedPreferences.getString(judul, "").toString()
    }

    companion object {
        fun newInstance(notes: Notes):NotesFragment{
            return  NotesFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("notes", notes)
                }
            }
        }
    }
}