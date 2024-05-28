package br.unisanta.mvvmlogin.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.unisanta.mvvmlogin.database.dao.UserDao
import br.unisanta.mvvmlogin.database.dao.ProductDao
import br.unisanta.mvvmlogin.model.User
import br.unisanta.mvvmlogin.model.Product

@Database(entities = [User::class, Product::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun productDao(): ProductDao
}

