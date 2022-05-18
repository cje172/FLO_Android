package com.example.flo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "UserTable")
data class User(
    @SerializedName(value = "email") var email: String,
    @SerializedName(value = "password") var password: String,
    @SerializedName(value = "name") var name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
