package dhara.mca.calculateapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.Adapter as Adapter
import android.widget.ArrayAdapter as ArrayAdapter

class CurrencyConvertorActivity : AppCompatActivity() {

    lateinit var sp1 : Spinner
    lateinit var sp2 : Spinner
    lateinit var convertButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_convertor)

        sp1 = findViewById(R.id.FromSpinner)
        sp2 = findViewById(R.id.ToSpinner)

        var ed = findViewById<EditText>(R.id.edAmount)

        var from = arrayOf("Indian Rupees INR","USD",)
        var adapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,from)
        sp1.adapter = adapter

        var to = arrayOf("Indian Rupees INR","Australian Dollar AUD","USD")
        var adapter2 = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,to)
        sp2.adapter = adapter2

        convertButton =  findViewById(R.id.buConvert)
        convertButton.setOnClickListener {
            var total : Double
            var amt = (ed.getText().toString()).toDouble()
            var tv = findViewById<TextView>(R.id.displayText)
            if(sp1.selectedItem.toString() == "USD" && sp2.selectedItem.toString() == "Indian Rupees INR"){
                total = amt * 74.506
                //Toast.makeText(applicationContext,total.toString(),Toast.LENGTH_LONG).show()
                tv.visibility = View.VISIBLE
                tv.setText(total.toString())
            }
            else if(sp1.selectedItem.toString() == "USD" && sp2.selectedItem.toString() == "Australian Dollar AUD"){
                total = amt * 54.777
                //Toast.makeText(applicationContext,total.toString(),Toast.LENGTH_LONG).show()
                tv.visibility = View.VISIBLE
                tv.setText(total.toString())
            }
            else if(sp1.selectedItem.toString() == "Indian Rupees INR" && sp2.selectedItem.toString() == "USD"){
            total = amt * 0.0134
            //Toast.makeText(applicationContext,total.toString(),Toast.LENGTH_LONG).show()
            tv.visibility = View.VISIBLE
            tv.setText(total.toString())
            }
            else if(sp1.selectedItem.toString() == "Indian Rupees INR" && sp2.selectedItem.toString() == "Australian Dollar AUD"){
                total = amt * 0.0183
                //Toast.makeText(applicationContext,total.toString(),Toast.LENGTH_LONG).show()
                tv.visibility = View.VISIBLE
                tv.setText(total.toString())
            }

        }
        var buAgeCalc = findViewById<Button>(R.id.buAgeCalc)
        var buCalculator = findViewById<Button>(R.id.buCalculator)
        var buBinary = findViewById<Button>(R.id.buBinary)

        buAgeCalc.setOnClickListener {
            var intent = Intent(applicationContext,AgeCalculatorActivity::class.java)
            startActivity(intent)
        }
        buCalculator.setOnClickListener {
            var intent = Intent(applicationContext,CalculatorActivity::class.java)
            startActivity(intent)
        }
        buBinary.setOnClickListener {
            var intent = Intent(applicationContext,BinaryConvertorActivity::class.java)
            startActivity(intent)
        }

    }

}