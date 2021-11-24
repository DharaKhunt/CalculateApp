package dhara.mca.calculateapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class FirstPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)

        var calculator = findViewById<ImageView>(R.id.calculator)
        var agecalculator = findViewById<ImageView>(R.id.agecalculator)
        var cc = findViewById<ImageView>(R.id.currencyconvertor)
        var binary = findViewById<ImageView>(R.id.binaryConvert)

        calculator.setOnClickListener {
            var intent = Intent(applicationContext,CalculatorActivity::class.java)
            startActivity(intent)
        }
        agecalculator.setOnClickListener {
            var intent = Intent(applicationContext,AgeCalculatorActivity::class.java)
            startActivity(intent)
        }
        cc.setOnClickListener {
            var intent = Intent(applicationContext,CurrencyConvertorActivity::class.java)
            startActivity(intent)
        }
        binary.setOnClickListener {
            var intent = Intent(applicationContext,BinaryConvertorActivity::class.java)
            startActivity(intent)
        }

    }
}