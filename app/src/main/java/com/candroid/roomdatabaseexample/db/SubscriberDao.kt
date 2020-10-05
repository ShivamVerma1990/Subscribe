package com.candroid.roomdatabaseexample.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDao {
@Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSub(subscriber: Subscriber)
@Delete
    suspend fun deleteSub(subscriber: Subscriber)
@Update
    suspend fun updateSub(subscriber: Subscriber)
@Query("DELETE FROM subscriber_tab")
    suspend fun deleteAll()

@Query("SELECT*FROM subscriber_tab")
fun getAll():LiveData<List<Subscriber>>
}