package app.kushagra.takeoff.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import app.kushagra.takeoff.R
import app.kushagra.takeoff.model.QuickDataModel
import com.bumptech.glide.Glide

class RoundedButtonRecyclerAdapter(

    private var dataList: ArrayList<QuickDataModel>,
    private var context: Context
) :
    RecyclerView.Adapter<RoundedButtonRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layout: ConstraintLayout = itemView.findViewById(R.id.layout)
        val image:ImageView = itemView.findViewById(R.id.card_image)
        val title: TextView = itemView.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_recycler_rounded_button, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = dataList[position]
        holder.image.setBackgroundColor(dataItem.background!!)
        holder.title.text = dataItem.title
        Glide.with(context).load(dataItem.image).into(holder.image)


    }
}