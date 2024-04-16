package ru.appsmile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.appsmile.ItemData
import ru.appsmile.first.R

class NumberAdapter1(private val numberList: List<Int>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class NumberViewHolder3(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.litic)
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
                if (numberList[position] % 2 == 0) {
                    holder.textView.text = "Perfectionism"
                } else {
                    holder.textView.text = "Analitics"
                }
            }
        }
    }



}