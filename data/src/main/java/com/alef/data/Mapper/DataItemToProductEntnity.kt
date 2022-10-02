package com.alef.data.Mapper

import com.alef.data.source.remote.models.DataItem
import com.alef.domain.entities.ProductEntity


fun DataItem.toEntity(): ProductEntity {
    return ProductEntity(
        Id = this.id ?: 0,
        Name = this.title ?: "",
        Description = this.description ?: "",
        prepare_time = this.prepareTime ?: 0,
        avg_rate = this.avgRate?.toDouble() ?: 0.0,
        ImagePath = this.mainImage ?: this.images?.get(0)?.imageName ?: "",
        price = this.prices?.get(0)?.price ?: 0.0,
        isFav = false,
    )

}
