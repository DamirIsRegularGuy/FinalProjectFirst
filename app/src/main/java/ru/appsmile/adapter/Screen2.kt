package ru.appsmile.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import ru.appsmile.ItemData
import ru.appsmile.first.R


class Screen2(private val numberList: List<Int>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    class NumberViewHolder3(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.litic)
        val cardView: CardView = view.findViewById(R.id.toop)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.firstscrol, parent, false)

        return NumberViewHolder3(view)
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        when {
            holder is NumberViewHolder3 -> {
                if (numberList[position] % 2 != 0) {
                    holder.textView.text = "Perfectionism"
                    holder.textView.setTextColor(Color.parseColor("#FF7E73"))
                    holder.cardView.setCardBackgroundColor(Color.parseColor("#FFF4F4"))
                } else {
                    holder.textView.text = "Analitics"
                    holder.textView.setTextColor(Color.parseColor("#FF7E73"))
                    holder.cardView.setCardBackgroundColor(Color.parseColor("#FFF4F4"))
                }
            }
        }
    }



}