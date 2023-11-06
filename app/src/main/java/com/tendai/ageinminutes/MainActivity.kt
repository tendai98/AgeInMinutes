package com.tendai.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var selectedDateText: TextView? = null
    private var ageInMinutesText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDatePicker :  Button = findViewById(R.id.button_date_picker)
        selectedDateText = findViewById(R.id.selected_date)
        ageInMinutesText = findViewById(R.id.age_in_minutes)

        buttonDatePicker.setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker() {

        val myCalendar = Calendar.getInstance()

        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                val selectedDate = String.format(
                    Locale.ENGLISH, "%d/%d/%d", selectedYear, selectedMonth+1, selectedDayOfMonth
                )

                selectedDateText?.text  = selectedDate

                val standardDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val dateObject = standardDateFormat.parse(selectedDate)

                dateObject?.let {

                    val selectedDateInMinutes = dateObject.time / 60000
                    val currentDate = standardDateFormat.parse(standardDateFormat.format(System.currentTimeMillis()))

                    currentDate?.let {
                        val currentDateInMinutes = currentDate.time / 60000
                        val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                        ageInMinutesText?.text = differenceInMinutes.toString()
                    }
                }

            },
            year,
            month,
            day
        )

        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()

    }
}