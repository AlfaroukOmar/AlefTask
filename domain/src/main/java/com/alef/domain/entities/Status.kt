package com.alef.domain.entities

data class Status<T>
    (
    val data: T?,
    val error: String
)