package com.candroid.roomdatabaseexample

import com.candroid.roomdatabaseexample.db.Subscriber
import com.candroid.roomdatabaseexample.db.SubscriberDatabase

class Repository(val db:SubscriberDatabase){

suspend fun insert(subscriber: Subscriber)=db.getDao().insertSub(subscriber)
suspend fun delete(subscriber: Subscriber)=db.getDao().deleteSub(subscriber)
suspend fun update(subscriber: Subscriber)=db.getDao().updateSub(subscriber)
    suspend fun deleteAll()=db.getDao().deleteAll()
fun getAll()=db.getDao().getAll()
}