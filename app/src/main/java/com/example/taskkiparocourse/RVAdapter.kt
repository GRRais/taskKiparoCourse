package com.example.taskkiparocourse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskkiparocourse.databinding.NewsCellBinding

class RVAdapter(private val newsCell: ArrayList<NewsCell>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class NewsCellViewHolder(var viewBinding: NewsCellBinding) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): RecyclerView.ViewHolder {
        val binding = NewsCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsCellViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as NewsCellViewHolder
        itemViewHolder.viewBinding.newsTitleTextview.text = newsCell[position].title
        itemViewHolder.viewBinding.newsDescriptionTextview.text = newsCell[position].description
        itemViewHolder.viewBinding.newsDateTextview .text = newsCell[position].date
        itemViewHolder.viewBinding.newsKeywordsTextview.text = newsCell[position].keywords.toString()
    }

    override fun getItemCount(): Int {
        return newsCell.size
    }

}