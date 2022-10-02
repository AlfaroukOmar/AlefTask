package com.alef.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alef.domain.entities.ProductEntity

@Entity
data class ProductDBEntity(
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val Name: String,
    val Description: String,
    val prepare_time: Int,
    val avg_rate: Double,
    val main_image: String,
    val price: Double,
    var isFav: Boolean = false
)


fun ProductEntity.toDb(): ProductDBEntity {
    return ProductDBEntity(
        Id,
        Name,
        Description,
        prepare_time,
        avg_rate,
        ImagePath,
        price,
        isFav
    )
}

fun ProductDBEntity.toEntity(): ProductEntity {
    return ProductEntity(
        Id,
        Name,
        Description,
        prepare_time,
        avg_rate,
        main_image,
        price,
        isFav
    )
}
