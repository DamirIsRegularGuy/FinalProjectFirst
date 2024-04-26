package ru.appsmile.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import final_mounth_project.Transfer_activity
import ru.appsmile.ItemData
import ru.appsmile.first.R

class all_countries(private val numberList: List<ItemData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class kolin(view: View): RecyclerView.ViewHolder(view){
        var krug: ImageView = view.findViewById(R.id.flagin)
        var strana: TextView = view.findViewById(R.id.hoop)
        var card_view: RelativeLayout = view.findViewById(R.id.all_countries)
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
            holder.card_view.setOnClickListener {
                val countries = holder.strana.text.toString()
                val intent = Intent(holder.itemView.context, Transfer_activity::class.java)
                intent.putExtra("strana1_name", countries)
                holder.itemView.context.startActivity(intent)
            }
        }
    }


}