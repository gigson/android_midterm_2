package com.example.second_midterm

import androidx.room.Database
import androidx.room.RoomDatabase

/*
* Created by ნიკოლოზ კაციტაძე on 5/21/20
*/

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}