package com.example.second_midterm.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.second_midterm.App
import com.example.second_midterm.NoteAdapter
import com.example.second_midterm.R
import kotlinx.android.synthetic.main.fragment_data.*

class DataFragment : Fragment(R.layout.fragment_data) {

    private lateinit var noteAdapter: NoteAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.initRecycler()
        this.getAllNotes()
    }

    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(context)
        noteList.layoutManager = layoutManager
        noteAdapter = NoteAdapter(ArrayList())
        noteList.adapter = noteAdapter;
    }

    private fun getAllNotes() {
        val notes = App.instance.db.getNoteDao().getAllNotes();
        noteAdapter.updateNotes(notes)
    }

}