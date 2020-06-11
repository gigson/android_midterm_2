package com.example.second_midterm.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.second_midterm.App
import com.example.second_midterm.R
import kotlinx.android.synthetic.main.fragment_statistics.*
import java.math.BigDecimal
import java.math.RoundingMode

class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val notes = App.instance.db.getNoteDao().getAllNotes();

        var transportTotal = 0.0;
        var transportCount = 0;

        var foodTotal = 0.0;
        var foodCount = 0;

        for (note in notes) {
            if (note.type.equals("Transport")) {
                transportTotal += note.amount
                transportCount++;
            }
            if (note.type.equals("Food")) {
                foodTotal += note.amount
                foodCount++;
            }
        }

        var transportAverage = if (transportCount > 0) transportTotal / transportCount else 0.0;
        var foodAverage = if (foodCount > 0) foodTotal / foodCount else 0.0;

        transportTotalView.text = BigDecimal(transportTotal).setScale(4, RoundingMode.HALF_EVEN).toPlainString();
        transportAverageView.text = BigDecimal(transportAverage).setScale(4, RoundingMode.HALF_EVEN).toPlainString();

        foodTotalView.text = BigDecimal(foodTotal).setScale(4, RoundingMode.HALF_EVEN).toPlainString();
        foodAverageView.text = BigDecimal(foodAverage).setScale(4, RoundingMode.HALF_EVEN).toPlainString();
    }

}