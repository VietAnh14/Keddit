package com.example.keddit.common.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.keddit.R
import com.example.keddit.common.extension.inflate
import com.example.keddit.databinding.NewsItemBinding
import com.example.keddit.model.RedditNewsItem
import com.example.keddit.model.ViewType

class NewsDelegateAdapter: ViewTypeDelegateAdapter {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsHolder
        holder.bind(item as RedditNewsItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: NewsItemBinding = DataBindingUtil.inflate(inflater, R.layout.news_item, parent, false)
        return NewsHolder(binding)
    }

    class NewsHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RedditNewsItem) {
            binding.news = item
        }
    }
}