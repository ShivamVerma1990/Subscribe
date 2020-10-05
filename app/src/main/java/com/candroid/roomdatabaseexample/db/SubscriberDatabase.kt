package com.candroid.roomdatabaseexample.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Subscriber::class],version = 1,exportSchema = false)
abstract class SubscriberDatabase():RoomDatabase() {

abstract fun getDao():SubscriberDao



    companion object{
        @Volatile
        private var instance: SubscriberDatabase?=null
        val Lock=Any()
        operator fun invoke(context: Context)= instance
            ?: synchronized(Lock){
                instance
                    ?: buildDatabase(
                        context
                    ).also {
                        instance =it
                    }
            }
        private fun buildDatabase(context: Context)= Room.databaseBuilder(context,
            SubscriberDatabase::class.java,"res_db").build()

    }

}