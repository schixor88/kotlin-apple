package app.kushagra.appledental.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.kushagra.appledental.R
import app.kushagra.appledental.model.DoctorModel
import kotlinx.android.synthetic.main.layout_recycler_item_doctor.view.*

class DoctorRecyclerAdapter(
    private val doctorList: ArrayList<DoctorModel>,
    private val context: Context
) : RecyclerView.Adapter<DoctorRecyclerAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val nmc: TextView = itemView.findViewById(R.id.nmc)
        val degree: TextView = itemView.findViewById(R.id.degree)
        val position: TextView = itemView.findViewById(R.id.position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_recycler_item_doctor, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return doctorList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val doctorItem = doctorList[position]
        holder.name.text = doctorItem.name
        holder.degree.text = doctorItem.degree
        holder.nmc.text = "NMC No: ${doctorItem.nmc}"
        holder.position.text = doctorItem.post
    }
}