package app.kushagra.appledental.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.kushagra.appledental.R
import app.kushagra.appledental.model.PriceModel

class MenuRecyclerAdapter(
    private val priceList: ArrayList<PriceModel>,
    private val context: Context
) :
    RecyclerView.Adapter<MenuRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val number: TextView = itemView.findViewById(R.id.number)
        val name: TextView = itemView.findViewById(R.id.name)
        val rate: TextView = itemView.findViewById(R.id.rate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_recycler_item_menu, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return priceList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = priceList[position]
        holder.name.text = dataItem.name
        holder.number.text = dataItem.number
        holder.rate.text = dataItem.rate
    }
}