package ru.appsmile.perevod
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.appsmile.ItemData
import ru.appsmile.adapter.country
import ru.appsmile.adapter.trem
import ru.appsmile.first.R


class SecondScreenPerevod: AppCompatActivity() {
    private var hope1: RecyclerView? = null
    private var but: AppCompatButton? = null
    private var poisk: SearchView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.perevod2screen)

        but = findViewById(R.id.strela)
        poisk = findViewById(R.id.yooh)

        but?.setOnClickListener{
            onBackPressed()
        }

        val spisok = listOf(
            ItemData(R.drawable.russia, "Россия"),
            ItemData(R.drawable.uzbekistan, "Узбекистан"),
            ItemData(R.drawable.tjk, "Таджикистан"),
            ItemData(R.drawable.kazakh, "Казахстан"),
            ItemData(R.drawable.korea, "Корея"),
            ItemData(R.drawable.uaa, "ОАЭ"),
            ItemData(R.drawable.ukrain, "Украина")
        )


        poisk?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val newList1 = spisok.filter {
                        it.strana.contains(newText!!, ignoreCase = true)
                }
                hope1?.adapter = trem(newList1)
                return true
            }
        })


        hope1 = findViewById(R.id.fira)
        hope1?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        hope1?.adapter = trem(spisok)




    }
}


