package com.rahil.noteapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rahil.noteapp.R
import com.rahil.noteapp.db.Note

class NoteAdapter(val note:List<Note>) : RecyclerView.Adapter<NoteAdapter.noteViewHolder>() {
    class noteViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val textTitle = view.findViewById<TextView>(R.id.text_view_title)
        val textNote = view.findViewById<TextView>(R.id.text_view_note)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteViewHolder {
        return noteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: noteViewHolder, position: Int) {
        holder.textTitle.text = note[position].title
        holder.textNote.text = note[position].note
    }

    override fun getItemCount(): Int {
        return note.size
    }


}