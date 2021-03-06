package com.rahil.noteapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM Note ORDER BY id DESC")
    suspend fun getAllNote() : List<Note>

    @Insert
    suspend fun addMultipleNote(vararg note: Note)
}