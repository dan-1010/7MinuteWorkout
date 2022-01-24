package com.example.a7minuteworkout

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minuteworkout.databinding.ItemHistoryRowBinding

class HIstoryAdapter(private var items:ArrayList<String>):RecyclerView.Adapter<HIstoryAdapter.viewHolder>() {




    class viewHolder(binding:ItemHistoryRowBinding):RecyclerView.ViewHolder(binding.root){
        val llHistoryItemMain= binding.llHistoryItemMain
        val tvItem=binding.tvItem
        val tvPosition=binding.tvPosition



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(ItemHistoryRowBinding.inflate(LayoutInflater.from(parent.context),
        parent,false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val date:String= items.get(position)
        holder.tvPosition.text= (position+1).toString()
        holder.tvItem.text= date


        if (position % 2 == 0) {
            holder.llHistoryItemMain.setBackgroundColor(
                Color.parseColor("#EBEBEB")
            )
        } else {
            holder.llHistoryItemMain.setBackgroundColor(
                Color.parseColor("#FFFFFF")
            )
        }




    }

    override fun getItemCount(): Int {
        return items.size
    }

}