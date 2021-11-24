package dhara.mca.calculateapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BinaryConvertorActivity : AppCompatActivity() {
    lateinit var ed :EditText
    lateinit var result :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binary_convertor)

        var buClac = findViewById<Button>(R.id.buCalc)
        var buAgeCalc = findViewById<Button>(R.id.buAgeCalc)
        var buCurrency = findViewById<Button>(R.id.buCurrency)

        buClac.setOnClickListener {
            var intent = Intent(applicationContext,CalculatorActivity::class.java)
            startActivity(intent)
        }
        buAgeCalc.setOnClickListener {
            var intent = Intent(applicationContext,AgeCalculatorActivity::class.java)
            startActivity(intent)
        }
        buCurrency.setOnClickListener {
            var intent = Intent(applicationContext,CurrencyConvertorActivity::class.java)
            startActivity(intent)
        }

        var buEncode = findViewById<Button>(R.id.buEncode)
        var buDecode = findViewById<Button>(R.id.buDecode)
        ed = findViewById(R.id.edInputText)
        result = findViewById(R.id.binaryConverted)

        buEncode.setOnClickListener {
            encode()
        }
        buDecode.setOnClickListener {
            decode()
        }
    }
    private fun encode(){
        var txt = ed.text.toString()
        var binary = BinaryConvertor.strToBinary(txt)
        result.text = binary
        hideKeybord()
    }
    private fun decode(){
        var binary = ed.text.toString()
        var txt = BinaryConvertor.binaryToString(binary)
        result.text = txt
        hideKeybord()
    }
    private fun hideKeybord(){
        var imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = currentFocus

        if(view == null)
            view = View(this)

        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}