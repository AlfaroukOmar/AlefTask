package com.alef.data.source.remote.models

import com.google.gson.annotations.SerializedName

data class FoodResponse(

    @field:SerializedName("data")
    val data: List<DataItem?>? = null,

    @field:SerializedName("isSuccessed")
    val isSuccessed: Boolean? = null,

    @field:SerializedName("error")
    val error: String? = null
)

data class PricesItem(

    @field:SerializedName("title_ar")
    val titleAr: String? = null,

    @field:SerializedName("unit")
    val unit: Any? = null,

    @field:SerializedName("is_active")
    val isActive: Int? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("price")
    val price: Double? = null,

    @field:SerializedName("product_id")
    val productId: Int? = null,

    @field:SerializedName("offer_end_date")
    val offerEndDate: Any? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("unit_id")
    val unitId: Any? = null,

    @field:SerializedName("offer_price")
    val offerPrice: Any? = null
)

data class Category(

    @field:SerializedName("title_ar")
    val titleAr: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("logo")
    val logo: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("published")
    val published: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("description_ar")
    val descriptionAr: String? = null
)

data class Provider(

    @field:SerializedName("account_number")
    val accountNumber: String? = null,

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("gov")
    val gov: String? = null,

    @field:SerializedName("reset_expiration")
    val resetExpiration: Any? = null,

    @field:SerializedName("zone")
    val zone: String? = null,

    @field:SerializedName("rate")
    val rate: Int? = null,

    @field:SerializedName("bank_name")
    val bankName: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("deposits_count")
    val depositsCount: Int? = null,

    @field:SerializedName("categories")
    val categories: List<CategoriesItem?>? = null,

    @field:SerializedName("confirm_expiration")
    val confirmExpiration: Any? = null,

    @field:SerializedName("lat")
    val lat: Double? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("images")
    val images: List<ImagesItem?>? = null,

    @field:SerializedName("wallet")
    val wallet: String? = null,

    @field:SerializedName("lng")
    val lng: Double? = null,

    @field:SerializedName("highKMPrice")
    val highKMPrice: Int? = null,

    @field:SerializedName("lowest_value")
    val lowestValue: Any? = null,

    @field:SerializedName("mobile")
    val mobile: String? = null,

    @field:SerializedName("country_code")
    val countryCode: String? = null,

    @field:SerializedName("fees_percentage")
    val feesPercentage: Any? = null,

    @field:SerializedName("confirm_code")
    val confirmCode: Any? = null,

    @field:SerializedName("iban")
    val iban: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("lowKMPrice")
    val lowKMPrice: Int? = null,

    @field:SerializedName("reset_status")
    val resetStatus: Int? = null,

    @field:SerializedName("slogan")
    val slogan: String? = null,

    @field:SerializedName("status")
    val status: Int? = null
)

data class CategoriesItem(

    @field:SerializedName("title_ar")
    val titleAr: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("logo")
    val logo: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("published")
    val published: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("description_ar")
    val descriptionAr: String? = null
)

data class DataItem(

    @field:SerializedName("images")
    val images: List<ImagesItem?>? = null,

    @field:SerializedName("is_active")
    val isActive: Int? = null,

    @field:SerializedName("main_image")
    val mainImage: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("avg_rate")
    val avgRate: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("title_ar")
    val titleAr: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("category_id")
    val categoryId: Int? = null,

    @field:SerializedName("provider")
    val provider: Provider? = null,

    @field:SerializedName("approved_by_admin")
    val approvedByAdmin: Int? = null,

    @field:SerializedName("review")
    val review: List<Any?>? = null,

    @field:SerializedName("count_users_review")
    val countUsersReview: Int? = null,

    @field:SerializedName("prepare_time")
    val prepareTime: Int? = null,

    @field:SerializedName("provider_id")
    val providerId: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("prices")
    val prices: List<PricesItem?>? = null,

    @field:SerializedName("category")
    val category: Category? = null,

    @field:SerializedName("description_ar")
    val descriptionAr: String? = null
)

data class ImagesItem(

    @field:SerializedName("image_name")
    val imageName: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("admin_id")
    val adminId: Int? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("imageable_id")
    val imageableId: Int? = null,

    @field:SerializedName("imageable_type")
    val imageableType: String? = null
)
