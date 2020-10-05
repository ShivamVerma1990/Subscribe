package com.candroid.roomdatabaseexample.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Subscriber_tab")
data class Subscriber(
@ColumnInfo(name = "name") var subscriberName:String,
@ColumnInfo(name = "email")var subscriberEmail: String
) {
    @PrimaryKey(autoGenerate = true)var id:Int=0

}