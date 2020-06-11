package com.example.second_midterm

import androidx.room.*

@Dao
interface NoteDao {

    @Query("SELECT * FROM NOTES")
    fun getAllNotes(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg notes: Note)

}