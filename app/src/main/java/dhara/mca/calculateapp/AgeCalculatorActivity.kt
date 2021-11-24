package dhara.mca.calculateapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class AgeCalculatorActivity : AppCompatActivity() {
    lateinit var ed : EditText
    lateinit var tv : TextView
    lateinit var ageButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_calculator)

        var buCalc = findViewById<Button>(R.id.buCalc)
        var buCurrency = findViewById<Button>(R.id.buCurrency)
        var buBinary = findViewById<Button>(R.id.buBinary)

        buCalc.setOnClickListener {
            var intent = Intent(applicationContext,CalculatorActivity::class.java)
            startActivity(intent)
        }
        buCurrency.setOnClickListener {
            var intent = Intent(applicationContext,CurrencyConvertorActivity::class.java)
            startActivity(intent)
        }
        buBinary.setOnClickListener {
            var intent = Intent(applicationContext,BinaryConvertorActivity::class.java)
            startActivity(intent)
        }

    }

    fun openDateTimePicker(view: View) {
        ed = findViewById(R.id.ed1)
        ageButton = findViewById(R.id.ageButton)
        var c = Calendar.getInstance()

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, yy, mm, dd ->
            var dt = "$dd/${mm+1}/$yy"
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, hh, mi ->
                dt += "  $hh:$mi"
                ed.setText(dt)
            },c.get(Calendar.HOUR),c.get(Calendar.MINUTE),false).show()
        },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
    }

    fun CalculateAge(view: View) {
        ed = findViewById(R.id.ed1)
        tv = findViewById(R.id.tv)

        var todayDate = Date()

        var dobs = ed.text.toString()
        var simpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
        var dob = simpleDateFormat.parse(dobs)


        var days = (todayDate.time - dob.time)/86400000
        var hours = (todayDate.time - dob.time)%8600000/3600000
        var minutes =(todayDate.time - dob.time)%8600000%3600000/60000
        var seconds  = (todayDate.time - dob.time)%8600000%3600000%60000/1000
        var year = days / 365
        var month = days / 30

        tv.visibility = View.VISIBLE
        tv.setText("Years : $year\nMonth : $month\nDays : $days\nHours : $hours\nMinutes : $minutes\nSeconds:$seconds")
    }
}