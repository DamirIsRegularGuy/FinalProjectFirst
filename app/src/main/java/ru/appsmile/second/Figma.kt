package ru.appsmile.second

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import ru.appsmile.adapter.NumberAdapter
import ru.appsmile.adapter.NumberAdapter1
import ru.appsmile.adapter.Screen2
import ru.appsmile.adapter.favorite
import ru.appsmile.first.R

class Figma: AppCompatActivity() {
    private var numberPanel1: RecyclerView? = null
    private var numberPanel2: RecyclerView? = null
    private var numberPanel3: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firma1)

        numberPanel1 = findViewById(R.id.root1)
        numberPanel1?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        numberPanel1?.adapter = NumberAdapter1((1..10).toList())

        numberPanel2 = findViewById(R.id.root2)
        numberPanel2?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        numberPanel2?.adapter = Screen2((1..10).toList())

        numberPanel3 = findViewById(R.id.root3)
        numberPanel3?.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        numberPanel3?.adapter = favorite((1..10).toList())



    }
}