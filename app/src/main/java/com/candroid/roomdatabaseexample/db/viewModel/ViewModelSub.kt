package com.candroid.roomdatabaseexample.db.viewModel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.*
import com.candroid.roomdatabaseexample.Repository
import com.candroid.roomdatabaseexample.db.Event
import com.candroid.roomdatabaseexample.db.Subscriber
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelSub (val rep:Repository):ViewModel(),Observable{
lateinit var subscriberIns: Subscriber
    var isUpdate=false
val staMsg=MutableLiveData<Event<String>>()
    val msg:LiveData<Event<String>>
        get() =staMsg

    @Bindable
  val inputEmail=MutableLiveData<String>()
          @Bindable
          val inputName=MutableLiveData<String>()

    @Bindable
    val updateOrSavetext=MutableLiveData<String>()
    @Bindable
val deletOrCleartext=MutableLiveData<String>()
init {

    updateOrSavetext.value="save"
deletOrCleartext.value="Clear"

}
fun updateOrSave(){
    if(isUpdate) {

   subscriberIns.subscriberName=inputName.value!!
        subscriberIns.subscriberEmail=inputEmail.value!!
        update(subscriberIns)



    }
else{
        val name = inputName.value!!
        val email = inputEmail.value!!
        val subscriber = Subscriber(name, email)
        insert(subscriber)
        inputName.value = null
        inputEmail.value = null
        updateOrSavetext.value="save"
        deletOrCleartext.value="Clear"

    }

}
fun clearordelete() {
    if (isUpdate) {
 delete(subscriberIns)

    } else {
        deleteAll()

    }
}
    fun insert(subscriber: Subscriber)=viewModelScope.launch {
      rep.insert(subscriber)
        staMsg.value= Event("succesfully insert")
    }
fun delete(subscriber: Subscriber)=viewModelScope.launch {
    rep.delete(subscriber)
isUpdate=false
    inputEmail.value = null
    inputEmail.value = null
    updateOrSavetext.value="save"
    deletOrCleartext.value="Clear"
    staMsg.value= Event("succesfully delete")

}
  fun update(subscriber: Subscriber)=viewModelScope.launch {
      rep.update(subscriber)
isUpdate=false
      inputEmail.value = null
      inputEmail.value = null
      updateOrSavetext.value="save"
      deletOrCleartext.value="Clear"
      staMsg.value= Event("succesfully update")
  }
    fun getAll()=rep.getAll()
fun deleteAll()=viewModelScope.launch {
    rep.deleteAll()
    staMsg.value= Event("succesfully delete all")
}

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

fun initUpdateordelete(subscriber: Subscriber){
    inputName.value=subscriber.subscriberName
    inputEmail.value=subscriber.subscriberEmail
    isUpdate=true
    updateOrSavetext.value="Update"
    deletOrCleartext.value="Delete"
subscriberIns=subscriber

}


}
