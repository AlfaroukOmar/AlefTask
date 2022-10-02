package com.alef.task.presentation.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alef.domain.entities.ProductEntity
import com.alef.task.R
import com.alef.task.common.ItemClicked
import com.alef.task.common.ParentAdapter
import com.alef.task.common.ex.loadImage
import com.alef.task.databinding.ItemProductBinding

class FavouriteAdapter : ParentAdapter<FavouriteVH, ProductEntity>() {
    override fun get_layout(): Int {
        return R.layout.item_product
    }

    lateinit var itemClicked: ItemClicked

    override fun getViewHolder(v: View?): FavouriteVH {
        return FavouriteVH(v!!)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FavouriteVH, position: Int) {
        val item = getItem(position)!!

        holder.binding.name.text = item.Name
        holder.binding.description.text = item.Description
        holder.binding.image.loadImage(item.ImagePath)
        holder.binding.rating.rating = item.avg_rate.toFloat()
        holder.binding.value.text = item.price.toString()
        holder.binding.prepareTime.text = item.prepare_time.toString()

        holder.binding.favorite.setOnCheckedChangeListener { compoundButton, b ->
            itemClicked.clickItemFav(item, b)

            if (!b)
                remove(item)
        }
    }
}


class FavouriteVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var binding: ItemProductBinding = ItemProductBinding.bind(itemView)
}