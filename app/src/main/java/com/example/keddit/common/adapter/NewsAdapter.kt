package com.example.keddit.common.adapter

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.keddit.model.RedditNewsItem
import com.example.keddit.model.ViewType

class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: ArrayList<ViewType> = ArrayList()
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private var loadingItem = object : ViewType {
        override fun getViewType(): Int = AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.NEWS, NewsDelegateAdapter())
        items.add(loadingItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType)?.onCreateViewHolder(parent)!!
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val adapterType = items.get(position).getViewType()
        delegateAdapters.get(adapterType)!!.onBindViewHolder(holder, items.get(position))
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].getViewType()
    }

    fun addNews(news: List<RedditNewsItem>) {
        val pos = items.lastIndex
        items.removeAt(pos)
        items.addAll(pos, news)
        notifyItemRangeInserted(pos, pos + news.size)
    }

    fun clearAndAddNews(news: List<RedditNewsItem>) {
        items.clear()
        items.addAll(news)
        items.add(loadingItem)
        notifyItemRangeInserted(0, items.size)
    }

    fun getNews(): List<RedditNewsItem> {
        return items.filter {
            it.getViewType() == AdapterConstants.NEWS
        }.map { it as RedditNewsItem }
    }
}