package br.unisanta.mvvmlogin.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    val pid: Int,
    val product_name: String,
    val product_price: Double
)
