package br.unisanta.mvvmlogin.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.unisanta.mvvmlogin.model.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM User")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM User WHERE user_name = :userName AND password = :password")
    fun checkLogin(userName: String, password: String): User?
}
