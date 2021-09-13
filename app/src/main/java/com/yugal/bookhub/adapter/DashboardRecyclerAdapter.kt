package com.yugal.bookhub.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.yugal.bookhub.R
import com.yugal.bookhub.model.Book
import org.w3c.dom.Text

class DashboardRecyclerAdapter(val context: Context, val itemList: ArrayList<Book>) : RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)

        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
       val book = itemList[position]
        holder.txtBookName.text = book.bookName
        holder.txtBookAuthor.text = book.bookAuthor
        holder.txtBookPrice.text = book.bookCost
        holder.txtBookRating.text = book.bookRating
        holder.imgBookImage.setImageResource(book.bookImage)

        holder.llContent.setOnClickListener(){
            Toast.makeText(context,"Clicked on ${holder.txtBookName.text.toString()}",Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class DashboardViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtBookName: TextView = view.findViewById(R.id.txtRecyclerBookName)
        val txtBookAuthor: TextView = view.findViewById(R.id.txtRecyclerAuthorName)
        val txtBookPrice: TextView = view.findViewById(R.id.txtRecyclerPrice)
        val txtBookRating: TextView = view.findViewById(R.id.rating)
        val imgBookImage: ImageView = view.findViewById(R.id.profile_image)
        val llContent: RelativeLayout = view.findViewById(R.id.llContent)
    }
}