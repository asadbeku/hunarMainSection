package com.example.mainapphunar.types

data class ProductType(
    val id: Int,
    val soha_uz: String,
    val soha_ru: String?,
    val soha_en: String?,
    val user: Int,
    val name_uz: String,
    val name_ru: String?,
    val name_en: String?,
    val weight: Int,
    val massa: String,
    val compound_uz: String,
    val compound_ru: String?,
    val compound_en: String?,
    val price: String,
    val status: Boolean,
    val e_status: Boolean,
    val main_image: String,
    val image_2: String,
    val image_3: String,
    val image_4: String
)