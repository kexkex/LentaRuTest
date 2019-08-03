package ru.tomindapps.lentarutest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.tomindapps.lentarutest.R
import ru.tomindapps.lentarutest.models.NewsModel
import java.util.*
import kotlin.collections.ArrayList

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    var newsList = ArrayList<NewsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(v)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    fun setupNewsList(news: ArrayList<NewsModel>){
        this.newsList = news
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
        val tvModified = itemView.findViewById<TextView>(R.id.tv_modified)
        val tvLink = itemView.findViewById<TextView>(R.id.tv_link)

        fun bind(newsModel: NewsModel){
            tvTitle.text = newsModel.title
            val date = Date()
            date.time = newsModel.modifiied
            tvModified.text = date.toString()
            tvLink.text = newsModel.link
        }
    }
}