package ru.appsmile.adapter

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import ru.appsmile.first.R

class favorite(private val numberList: List<Int>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class loop(view: View) : RecyclerView.ViewHolder(view) {
        val card: CardView = view.findViewById(R.id.cardif)
        val textView1: TextView = view.findViewById(R.id.text1)
        val img: ImageView = view.findViewById(R.id.foto1)
        val img2: ImageView = view.findViewById(R.id.foto2)
        var a = 1
        var b = 2
        var c = 3
        var d = 4
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.secondscrol, parent, false)
        return loop(view)
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is loop){
            if(numberList[position] % 4 == 1){
                holder.card.setCardBackgroundColor(Color.parseColor("#F6F5FB"))
                holder.textView1.text = "Astro- psychological report"
                holder.textView1.setTextColor(Color.parseColor("#291C6D"))
                holder.img.setImageResource(R.drawable.user__8__1)
                holder.img2.isVisible = true
                holder.img2.setColorFilter(Color.parseColor("#291C6D"), PorterDuff.Mode.SRC_IN)
            }

            else if(numberList[position] % 4 == 2){
                holder.card.setCardBackgroundColor(Color.parseColor("#F5F9F9"))
                holder.textView1.text = "Monthly prediction report"
                holder.textView1.setTextColor(Color.parseColor("#479696"))
                holder.img.setImageResource(R.drawable.calendar__1__1)
                holder.img2.isVisible = true
                holder.img2.setColorFilter(Color.parseColor("#479696"), PorterDuff.Mode.SRC_IN)
            }

            else if(numberList[position] % 4 == 3){
                holder.card.setCardBackgroundColor(Color.parseColor("#FFF4F4"))
                holder.textView1.text = "Daily Prediction"
                holder.textView1.setTextColor(Color.parseColor("#FF5648"))
                holder.img.setImageResource(R.drawable.check_square_1)
                holder.img2.isVisible = true
                holder.img2.setColorFilter(Color.parseColor("#FF5648"), PorterDuff.Mode.SRC_IN)
            }

            else if(numberList[position] % 4 == 0){
                holder.card.setCardBackgroundColor(Color.parseColor("#FDF9FB"))
                holder.textView1.text = "Love report"
                holder.textView1.setTextColor(Color.parseColor("#C93F8D"))
                holder.img.setImageResource(R.drawable.vector4)
                holder.img2.isVisible = false
                holder.img2.setColorFilter(Color.parseColor("#C93F8D"), PorterDuff.Mode.SRC_IN)
            }

            else{
                holder.d = numberList[position] + 4
                holder.card.setCardBackgroundColor(Color.parseColor("#FDF9FB"))
                holder.textView1.text = "Love report"
                holder.textView1.setTextColor(Color.parseColor("#C93F8D"))
                holder.img.setImageResource(R.drawable.vector4)
                holder.img2.isVisible = false
                holder.img2.setColorFilter(Color.parseColor("#C93F8D"), PorterDuff.Mode.SRC_IN)
            }
        }
    }

}