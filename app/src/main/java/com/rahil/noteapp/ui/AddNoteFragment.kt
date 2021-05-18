package com.rahil.noteapp.ui

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rahil.noteapp.R
import com.rahil.noteapp.db.Note
import com.rahil.noteapp.db.NoteDatabase
import kotlinx.coroutines.launch


class AddNoteFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val etTitle = view?.findViewById<EditText>(R.id.edit_text_title)
        val etBody = view?.findViewById<EditText>(R.id.edit_text_body)
        val buttonSave = view?.findViewById<FloatingActionButton>(R.id.floatingActionButtonAddNote)
        buttonSave?.setOnClickListener {
            val noteTitle = etTitle?.text.toString().trim()
            val noteBody = etBody?.text.toString().trim()

            if (noteTitle.isEmpty()){
                etTitle?.error = "Title is required"
                etTitle?.requestFocus()
                return@setOnClickListener
            }
            if (noteBody.isEmpty()){
                etBody?.error = "Body is required"
                etBody?.requestFocus()
                return@setOnClickListener
            }
            launch {
                val note = Note(noteTitle, noteBody)
                context?.let {
                    NoteDatabase(it).getNoteDao().addNote(note)
                    it.toast("Save Note")
                }
            }
        }
    }

}