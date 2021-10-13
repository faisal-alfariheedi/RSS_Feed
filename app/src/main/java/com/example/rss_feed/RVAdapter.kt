package com.example.rss_feed

import android.content.Context
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val rv: ArrayList<xmlpars.Entry>, val cont: Context): RecyclerView.Adapter<RVAdapter.ItemViewHolder>()  {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ItemViewHolder {
        return RVAdapter.ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rvlist,parent,false )
        )
    }

    override fun onBindViewHolder(holder: RVAdapter.ItemViewHolder, position: Int) {
        val rvv = rv[position].title
        val rvvd= rv[position].author
        var cat="category: "
//        for (i in rv[position].category){
//            cat="$cat $i,"
//        }
        holder.itemView.apply {
            var rvlisting= findViewById<CardView>(R.id.rvlisting)
            var ct= findViewById<TextView>(R.id.cardtitle)
            var cd= findViewById<TextView>(R.id.carddesc)
            findViewById<TextView>(R.id.cat).text =cat
            findViewById<TextView>(R.id.date).text= "created: ${rv[position].published} updated: ${rv[position].updated}"
            ct.text = rvv.toString()
            cd.text = rvvd.toString()
            rvlisting.setOnClickListener {
                var html =if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Html.fromHtml(rv[position].summary, Html.FROM_HTML_MODE_COMPACT) } else { Html.fromHtml(rv[position].summary) }
                alert(html,rvv.toString(),cont)

            }
            Html.fromHtml(rv[position].summary)


        }
    }

    override fun getItemCount() = rv.size
}