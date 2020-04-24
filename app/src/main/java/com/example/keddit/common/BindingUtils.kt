package com.example.keddit.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("setImage")
fun setImage(image: ImageView, url: String) {
    Picasso.get().load(url).into(image)
}