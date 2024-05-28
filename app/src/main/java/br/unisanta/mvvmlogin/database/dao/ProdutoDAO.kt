package br.unisanta.mvvmlogin.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.unisanta.mvvmlogin.model.Product

@Dao
interface ProductDao {
    @Insert
    fun insertProduct(product: Product)

    @Query("SELECT * FROM Product")
    fun getAllProducts(): List<Product>
}
