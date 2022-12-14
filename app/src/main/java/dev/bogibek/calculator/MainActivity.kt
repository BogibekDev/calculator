package dev.bogibek.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var numberText = ""
    var number1: Int? = null
    var number2: Int? = null
    lateinit var bAdd: Button
    lateinit var bFive: Button
    lateinit var bFour: Button
    lateinit var bEqual: Button
    lateinit var etInput: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        //initials all button here
        etInput = findViewById(R.id.et_input)
        bAdd = findViewById(R.id.b_add)
        bFour = findViewById(R.id.b_four)
        bFive = findViewById(R.id.b_five)
        bEqual = findViewById(R.id.b_equal)

        //set to buttons clickListener here
        bAdd.setOnClickListener(this)
        bFour.setOnClickListener(this)
        bFive.setOnClickListener(this)
        bEqual.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        if (etInput.text.toString() == "0") etInput.setText("")
        when (p0?.id) {
            R.id.b_four -> {
                numberText += "4"
                etInput.setText(numberText)
            }
            R.id.b_five -> {
                numberText += "5"
                etInput.setText(numberText)

            }
            R.id.b_add -> {
                number1 = numberText.toInt()
                numberText = ""
                etInput.setText("")
            }
            R.id.b_equal -> {
                number2 = numberText.toInt()
                val result = number1!! + number2!!
                etInput.setText(result.toString())
            }
        }
    }
}