package com.example.second_midterm.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.second_midterm.App
import com.example.second_midterm.Note
import com.example.second_midterm.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transportButton.isChecked = true;

        addButton.setOnClickListener {
            var type = "";

            if (transportButton.isChecked) {
                type = transportButton.text.toString();
            }
            if (foodButton.isChecked) {
                type = foodButton.text.toString();
            }


            val amount = amountInput.text.toString().toDouble()
            App.instance.db.getNoteDao().insert(Note(0, type, amount))

            amountInput.text.clear()

            Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();
        }

    }

}