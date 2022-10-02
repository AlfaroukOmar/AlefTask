package com.alef.task.common.ex

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String) {

    Picasso.get()
        .load(url)
        .into(this)
    //  Glide.with(this.context).load(Constant.domain + url).into(this)
}