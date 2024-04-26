package ru.appsmile.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import final_mounth_project.Transfer_activity
import ru.appsmile.ItemData
import ru.appsmile.first.R
import ru.appsmile.perevod.MainActivity
import ru.appsmile.perevod.SecondScreenPerevod

class country(private val numberList: List<ItemData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class koli(view: View): RecyclerView.ViewHolder(view){
        var imf: ImageView = view.findViewById(R.id.img)
        var txt: TextView = view.findViewById(R.id.txt)
        var tos: CardView = view.findViewById(R.id.tos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.flags, parent, false)
        return koli(view)
    }

    override fun getItemCount(): Int {
        return (numberList.take(3)).size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is koli) {

            holder.imf.setImageResource(numberList[position].icon)
            holder.txt.text = numberList[position].strana

            holder.tos.setOnClickListener {
                val countries = holder.txt.text.toString()
                val intent = Intent(holder.itemView.context, Transfer_activity::class.java)
                intent.putExtra("strana_name", countries)
                holder.itemView.context.startActivity(intent)
            }
        }
    }



}