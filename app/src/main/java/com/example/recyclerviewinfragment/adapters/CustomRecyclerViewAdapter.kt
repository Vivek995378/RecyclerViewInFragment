package com.example.recyclerviewinfragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewinfragment.R
import com.example.recyclerviewinfragment.models.Course

class CustomRecyclerViewAdapter (private val mList: List<Course> , private val listener: OnItemClickListener) :
    RecyclerView.Adapter<CustomRecyclerViewAdapter.MyViewHolder>(){

    inner class MyViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) , View.OnClickListener {
        val tvCourse: TextView = itemView.findViewById(R.id.tvCourse)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val tvFee: TextView = itemView.findViewById(R.id.tvFee)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val result = mList[position]

        holder.tvCourse.text = result.courseName
        holder.tvDescription.text = result.descriptiom
        holder.tvFee.text = result.fee.toString()
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}