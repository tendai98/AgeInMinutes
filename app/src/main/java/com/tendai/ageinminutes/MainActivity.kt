package com.tendai.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var selectedDateText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDatePicker :  Button = findViewById(R.id.button_date_picker)
        selectedDateText = findViewById(R.id.selected_date);

        buttonDatePicker.setOnClickListener {
            showDatePicker();
        }
    }

    private fun showDatePicker() {
        val myCalendar = Calendar.getInstance()

        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                val selectedDate = String.format(
                    Locale.ENGLISH, "%d/%d/%d", selectedYear, selectedMonth+1, selectedDayOfMonth
                )

                selectedDateText?.text  = selectedDate

                val standardDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val dateObject = standardDateFormat.parse(selectedDate)
                
            },
            year,
            month,
            day
        ).show()
    }
}