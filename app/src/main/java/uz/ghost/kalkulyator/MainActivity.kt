package uz.ghost.kalkulyator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
import javax.xml.xpath.XPathExpression

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }
        bottun_bracket_left.setOnClickListener {
            input.text = addToinputText("(")
        }
        bottun_bracket_right.setOnClickListener {
            input.text = addToinputText(")")
        }
        bottom_0.setOnClickListener {
            input.text = addToinputText("0")
        }
        bottom_1.setOnClickListener {
            input.text = addToinputText("1")
        }
        bottom_2.setOnClickListener {
            input.text = addToinputText("2")
        }
        bottom_3.setOnClickListener {
            input.text = addToinputText("3")
        }
        bottom_4.setOnClickListener {
            input.text = addToinputText("4")
        }
        bottom_5.setOnClickListener {
            input.text = addToinputText("5")
        }
        bottom_6.setOnClickListener {
            input.text = addToinputText("6")
        }
        bottom_7.setOnClickListener {
            input.text = addToinputText("7")
        }
        bottom_8.setOnClickListener {
            input.text = addToinputText("8")
        }
        bottom_9.setOnClickListener {
            input.text = addToinputText("9")
        }
        bottom_dot.setOnClickListener {
            input.text = addToinputText(".")
        }
        bottom_division.setOnClickListener {
            input.text = addToinputText("%")
        }
        bottom_multiply.setOnClickListener {
            input.text = addToinputText("*")
        }
        subscrition.setOnClickListener {
            input.text = addToinputText("-")
        }
        bottom_addition.setOnClickListener {
            input.text = addToinputText("+")
        }
        bottom_equals.setOnClickListener {
            showResult()
        }
    }

    private fun addToinputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    private fun getInputextenent(): String {
        var expression = input.text.replace(Regex("%"), "/")
        expression = expression.replace(Regex("x"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputextenent()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}


