package ru.appsmile.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.appsmile.ItemData
import ru.appsmile.first.R

class trem(private val numberList: List<ItemData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class kolin(view: View): RecyclerView.ViewHolder(view){
        var krug: ImageView = view.findViewById(R.id.flagin)
        var strana: TextView = view.findViewById(R.id.hoop)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.spisok, parent, false)
        return kolin(view)
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    @SuppressLint("DiscouragedApi")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is kolin){
            holder.krug.setImageResource(numberList[position].icon)
            holder.strana.text = numberList[position].strana
        }
    }


}