package ru.appsmile.perevod

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import ru.appsmile.ItemData
import ru.appsmile.adapter.NumberAdapter1
import ru.appsmile.adapter.Screen2
import ru.appsmile.adapter.country
import ru.appsmile.first.R
import ru.appsmile.second.Figma
import ru.appsmile.second.ManualActivity
import java.io.Serializable


class FirstSceenPerevod: AppCompatActivity() {
    private  var buttoncol: AppCompatButton?  = null
    private var hope: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.perevod1screen)

        buttoncol = findViewById(R.id.colbut)

        val spisok = listOf(
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

            //intent.putExtra("list", spisok as Serializable)
            startActivity(intent)
        }

        hope = findViewById(R.id.groot)
        hope?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        hope?.adapter = country(spisok)

    }
}

