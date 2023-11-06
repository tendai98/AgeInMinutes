package com.tendai.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDatePicker :  Button = findViewById(R.id.button_date_picker)

        buttonDatePicker.setOnClickListener {
            showDatePicker();
        }
    }

    private fun showDatePicker() {
        val myCalendar = Calendar.getInstance()

        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(applicationContext,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                
            },
            year,
            month,
            day
        )
    }
}