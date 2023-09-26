package com.example.jalsanket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jalsanket.data.FetchedData

class customadapter(private val Issue : List<FetchedData>): RecyclerView.Adapter<customadapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleIssue)
        val descriptionTextView: TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val map = mapOf(0 to "Contaminated Pond/Lakes", 1 to "Drainage", 2 to "Flood", 3 to "Pipe Burst/Infrastructure Damage")
        val item = Issue[position]
        val resultString = map[item.result ?: 0] ?: "Unknown"
        holder.titleTextView.text = resultString
        holder.descriptionTextView.text = item.description
    }

    override fun getItemCount(): Int {
        return Issue.size
    }
}