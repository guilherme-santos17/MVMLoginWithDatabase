package br.unisanta.mvvmlogin.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
                @PrimaryKey(autoGenerate = true)
                val uid:Int,
                val user_name:String,
                val password:String)
