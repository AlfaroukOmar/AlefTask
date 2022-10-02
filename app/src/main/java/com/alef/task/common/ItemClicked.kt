package com.alef.task.common

import com.alef.domain.entities.ProductEntity

interface ItemClicked {

    fun clickItemFav(item: ProductEntity, isFav: Boolean) {}
}