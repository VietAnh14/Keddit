package com.example.keddit.common.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.keddit.model.ViewType

interface ViewTypeDelegateAdapter {
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
}