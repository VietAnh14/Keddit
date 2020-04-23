package com.example.keddit.common.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.keddit.R
import com.example.keddit.common.extension.inflate
import com.example.keddit.model.ViewType

class LoadingDelegateAdapter: ViewTypeDelegateAdapter {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {

    }

    override fun onCreateViewHolder(parent: ViewGroup):
            RecyclerView.ViewHolder = TurnViewHolder(parent)

    class TurnViewHolder(parent: ViewGroup):
        RecyclerView.ViewHolder(parent.inflate(R.layout.news_item_loading)) {

    }
}