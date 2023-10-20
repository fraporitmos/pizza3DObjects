package com.fraporitmos.englishtenses.data.remote


@kotlinx.serialization.Serializable
internal data class PizzaRemote (
    val id: Int,
    val name: String,
    val desc: String,
    val img: String,
    val obj_android: String,
    val obj_ios: String,
    val price: Double,
)
