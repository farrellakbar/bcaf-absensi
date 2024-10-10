package com.example.aplikasiabsensi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasiabsensi.R
import com.example.aplikasiabsensi.model.Notes

class NotesAdapter(val notesList: List<Notes>, val onClick: (Notes) -> Unit) :RecyclerView.Adapter<NotesAdapter.NoteViewHolder>(){
     class NoteViewHolder (itemview: View,val onClick: (Notes) -> Unit) : RecyclerView.ViewHolder(itemview) {
        val txtJudulNotes = itemview.findViewById<TextView>(R.id.txtJudulNotes)
        val containerNotes = itemview.findViewById<LinearLayout>(R.id.containerItemNotes)
        fun bind(notes: Notes){
            txtJudulNotes.text = notes.judul
            containerNotes.setOnClickListener {
                onClick(notes)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false)
        return NoteViewHolder(view, onClick )
    }
    override fun getItemCount(): Int {
        return notesList.size
    }
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notesList[position]
        holder.bind(note)
    }
}