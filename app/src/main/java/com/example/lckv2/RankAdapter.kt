package com.example.lckv2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class RankAdapter(private val rankList : ArrayList<Rank>) : RecyclerView.Adapter<RankAdapter.RankViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_rank, parent, false)
        return RankViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RankViewHolder, position: Int) {
        val currentItem = rankList[position]
        holder.teamImage.setImageResource(currentItem.teamImage)
        holder.teamnames.text = currentItem.teamnames
    }

    override fun getItemCount(): Int {
        return rankList.size
    }

    class RankViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teamImage :ShapeableImageView = itemView.findViewById(R.id.team_image)
        val teamnames : TextView = itemView.findViewById(R.id.tname)
    }
}