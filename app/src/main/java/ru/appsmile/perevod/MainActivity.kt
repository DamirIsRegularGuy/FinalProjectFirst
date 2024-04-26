package ru.appsmile.perevod

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import ru.appsmile.ItemData
import ru.appsmile.adapter.country
import ru.appsmile.first.R


class MainActivity: AppCompatActivity() {
    private var sharedPreferencesNumber: SharedPreferences? = null

    private var buttoncol: AppCompatButton?  = null
    private var hope: RecyclerView? = null
    private var material_card: MaterialCardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        sharedPreferencesNumber = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        buttoncol = findViewById(R.id.colbut)
        material_card = findViewById(R.id.mat_card_exit)

        val spisok = listOf<ItemData>(
            ItemData(R.drawable.russia, "Россия"),
            ItemData(R.drawable.uzbekistan, "Узбекистан"),
            ItemData(R.drawable.tjk, "Таджикистан"),
            ItemData(R.drawable.kazakh, "Казахстан"),
            ItemData(R.drawable.korea, "Корея"),
            ItemData(R.drawable.uaa, "ОАЭ"),
            ItemData(R.drawable.ukrain, "Украина")
            )

        buttoncol?.setOnClickListener {
            val intent = Intent(this, SecondScreenPerevod::class.java)

            //intent.putExtra("list", spisok.toTypedArray())
            startActivity(intent)
        }

        material_card?.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle("Вы действительно хотите выйти?")
                .setMessage("При нажатии ОК все Ваши данные будут удалены безвозвратно")
                .setNegativeButton("Отмена") { dialog, which ->
                }
                .setPositiveButton("ОК") { dialog, which ->
                    sharedPreferencesNumber?.edit()?.remove("abonent_number")?.apply()
                    finishAffinity()
                }
                .show()
        }

        hope = findViewById(R.id.groot)
        hope?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        hope?.adapter = country(spisok)

    }
}

