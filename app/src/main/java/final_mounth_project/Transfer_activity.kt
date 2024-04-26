package final_mounth_project

import android.os.Bundle
import android.view.KeyEvent
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.doAfterTextChanged
import ru.appsmile.first.R

class Transfer_activity : AppCompatActivity() {
    private var card_number: EditText? = null
    private var sum_pay: EditText? = null
    private var preview_transfer: TextView? = null
    private var string_country: String? = null
    private var backbutton: AppCompatButton? = null
    private var continueButton: AppCompatButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transfer_activity)

        preview_transfer = findViewById(R.id.preview_transfer)

        if(!(intent.getStringExtra("strana_name").isNullOrEmpty())) string_country = intent.getStringExtra("strana_name")
        else if(!(intent.getStringExtra("strana1_name").isNullOrEmpty())) string_country = intent.getStringExtra("strana1_name")

        string_country = "Перевод в " + string_country
        preview_transfer?.text = string_country.toString()

        card_number = findViewById(R.id.numerCard)
        sum_pay = findViewById(R.id.edit_pay)
        backbutton = findViewById(R.id.back_but)
        continueButton = findViewById(R.id.button_continue)

        card_number?.setOnClickListener {
            card_number?.text?.clear()
        }

        card_number?.setOnEditorActionListener { _, actionId, event ->
            if (actionId == KeyEvent.KEYCODE_ENTER) {
                return@setOnEditorActionListener true
            }
            false
        }


        card_number?.doAfterTextChanged { text ->
            if (text != null) {
                if (text.length <= 19) {
                    if ((text.length == 4 || text.length == 9 || text.length == 14)) {
                        val formattedText = StringBuilder(text)
                        formattedText.insert(text.length, " ")
                        card_number?.setText(formattedText)
                        card_number?.setSelection(formattedText.length)
                    }
                }
                else{
                    card_number?.setText(text.subSequence(0, 19))
                    card_number?.setSelection(19)
                }
            }
        }



        sum_pay?.setOnClickListener {
            sum_pay?.text?.clear()
        }

        sum_pay?.setOnEditorActionListener { _, actionId, event ->
            if (actionId == KeyEvent.KEYCODE_ENTER) {
                return@setOnEditorActionListener true
            }
            false
        }

        backbutton?.setOnClickListener{
            onBackPressed()
        }

        continueButton?.setOnClickListener {
            Toast.makeText(this, "Оплата прошла успешно", Toast.LENGTH_SHORT).show()
            onBackPressed()
        }

    }
}