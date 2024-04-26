package final_mounth_project

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.button.MaterialButton
import ru.appsmile.first.R
import ru.appsmile.perevod.MainActivity
import ru.appsmile.perevod.SecondScreenPerevod

class LoginActivity:AppCompatActivity() {

    private var sharedPreferencesNumber: SharedPreferences? = null

    private var number_edit: EditText? = null
    private var continue_button: MaterialButton? = null
    private var exit_but: AppCompatButton? = null
    private var check_box: CheckBox? = null

    private var abonent_number: String = ""
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferencesNumber = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)

        abonent_number = sharedPreferencesNumber?.getString("abonent_number","") ?: ""
        if(abonent_number == "") setContentView(R.layout.login_activity)
        else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        Log.d("TAG_TEST", "counter: ${sharedPreferencesNumber?.contains("abonent_number")}")

        number_edit = findViewById(R.id.edit_text_number)
        continue_button = findViewById(R.id.continue_but)
        check_box = findViewById(R.id.check_box)
        exit_but = findViewById(R.id.exit_but)

        number_edit?.setOnEditorActionListener { _, actionId, event ->
            if (actionId == KeyEvent.KEYCODE_ENTER) {
                return@setOnEditorActionListener true
            }
            false
        }


        number_edit?.doAfterTextChanged { text ->
            if (text != null && text.length > 9) {
                number_edit?.setText(text.subSequence(0, 9))
                number_edit?.setSelection(9)
                if(check_box?.isChecked == true){
                    continue_button?.setBackgroundColor(ContextCompat.getColor(this,R.color.checking))
                    continue_button?.setTextColor(ContextCompat.getColor(this,R.color.white))
                }
            }
        }

        check_box?.setOnCheckedChangeListener{ Check_Box, isChecked ->
            if(number_edit?.text?.length == 9 && isChecked){
                continue_button?.setBackgroundColor(ContextCompat.getColor(this,R.color.checking))
                continue_button?.setTextColor(ContextCompat.getColor(this,R.color.white))
            }
            else{
                continue_button?.setBackgroundColor(ContextCompat.getColor(this,R.color.notchecking))
                continue_button?.setTextColor(ContextCompat.getColor(this,R.color.black))
            }
        }

        continue_button?.setOnClickListener {
            if(number_edit?.text?.length == 9 && check_box?.isChecked == true){
                abonent_number = number_edit?.text.toString()
                sharedPreferencesNumber?.edit()?.putString("abonent_number", abonent_number)?.apply()
                Log.d("TAG_TEST", "counter: ${sharedPreferencesNumber?.contains("abonent_number")}")
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(this,"Не все условия выполнены", Toast.LENGTH_SHORT).show()
            }
        }

        exit_but?.setOnClickListener {
            finish()
        }

    }
}