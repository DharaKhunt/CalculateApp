package dhara.mca.calculateapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class CalculatorActivity : AppCompatActivity() {

    var isNewOp = true
    var oldNumber = ""
    var op = "*"

    lateinit var bu0: Button
    lateinit var bu1: Button
    lateinit var bu2: Button
    lateinit var bu3: Button
    lateinit var bu4: Button
    lateinit var bu5: Button
    lateinit var bu6: Button
    lateinit var bu7: Button
    lateinit var bu8: Button
    lateinit var bu9: Button
    lateinit var buplus :Button
    lateinit var buminus : Button
    lateinit var bumultiply : Button
    lateinit var budivide : Button
    lateinit var budot : Button
    lateinit var buplusminus : Button
    lateinit var ed : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        bu0 = findViewById(R.id.bu0)
        bu1 = findViewById(R.id.bu1)
        bu2 = findViewById(R.id.bu2)
        bu3 = findViewById(R.id.bu3)
        bu4 = findViewById(R.id.bu4)
        bu5 = findViewById(R.id.bu5)
        bu6 = findViewById(R.id.bu6)
        bu7 = findViewById(R.id.bu7)
        bu8 = findViewById(R.id.bu8)
        bu9 = findViewById(R.id.bu9)
        buplus = findViewById(R.id.buplus)
        buminus = findViewById(R.id.buminus)
        bumultiply = findViewById(R.id.bumultiply)
        budivide = findViewById(R.id.budevide)
        budot = findViewById(R.id.budot)
        buplusminus = findViewById(R.id.buplusminus)

        ed = findViewById(R.id.editText)

        var buageCalc = findViewById<Button>(R.id.buAgeCalc)
        var bucurrency = findViewById<Button>(R.id.buCurrency)
        var buBinary = findViewById<Button>(R.id.buBinary)

        buageCalc.setOnClickListener {
            var intent = Intent(applicationContext,AgeCalculatorActivity::class.java)
            startActivity(intent)
        }
        bucurrency.setOnClickListener {
            var intent = Intent(applicationContext,CurrencyConvertorActivity::class.java)
            startActivity(intent)
        }
        buBinary.setOnClickListener {
            var intent = Intent(applicationContext,BinaryConvertorActivity::class.java)
            startActivity(intent)
        }

    }

    fun acEvent(view: View) {
        ed.setText("0")
        isNewOp = true
    }
    fun numberEvent(view: View) {
        if(isNewOp)
            ed.setText("")
        isNewOp = false
        var buselect = view as Button
        var value = ed.text.toString()

        when(buselect.id){
            bu0.id -> {value+="0"}
            bu1.id -> {value+="1"}
            bu2.id -> {value+="2"}
            bu3.id -> {value+="3"}
            bu4.id -> {value+="4"}
            bu5.id -> {value+="5"}
            bu6.id -> {value+="6"}
            bu7.id -> {value+="7"}
            bu8.id -> {value+="8"}
            bu9.id -> {value+="9"}
            budot.id -> {value+="."}
            buplusminus.id -> {
                var no = value.toDouble() * -1
                value = no.toString()
            }
        }
        ed.setText(value)
    }
    fun percentEvent(view: View) {
        var no = ed.text.toString().toDouble() / 100
        ed.setText(no.toString())
        isNewOp = true
    }
    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = ed.text.toString()

        var buselect = view as Button
        when(buselect.id){
            buplus.id -> {op="+"}
            buminus.id -> {op="-"}
            bumultiply.id -> {op="*"}
            budivide.id -> {op="/"}
        }
    }
    fun eqalEvent(view: View) {
        var newNumber = ed.text.toString()
        var result = 0.0


        when(op){
            "+" -> {result =  oldNumber.toString().toDouble() + newNumber.toString().toDouble()}
            "-" -> {result =  oldNumber.toString().toDouble() - newNumber.toString().toDouble()}
            "*" -> {result =  oldNumber.toString().toDouble() * newNumber.toString().toDouble()}
            "/" -> {result =  oldNumber.toString().toDouble() / newNumber.toString().toDouble()}
        }
        ed.setText(result.toString())
    }

}