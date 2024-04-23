package ru.appsmile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import ru.appsmile.ItemData
import ru.appsmile.first.R

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
                Toast.makeText(
                    holder.itemView.context,
                    holder.txt.text.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}