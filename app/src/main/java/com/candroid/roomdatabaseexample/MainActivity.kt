package com.candroid.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.candroid.roomdatabaseexample.databinding.ActivityMainBinding
import com.candroid.roomdatabaseexample.db.Subscriber
import com.candroid.roomdatabaseexample.db.SubscriberDatabase
import com.candroid.roomdatabaseexample.db.viewModel.ViewModelFactory
import com.candroid.roomdatabaseexample.db.viewModel.ViewModelSub

class MainActivity : AppCompatActivity() {
lateinit var mView:ViewModelSub
lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
   val database=SubscriberDatabase(this)
    val rep=Repository(database)
      val factory=ViewModelFactory(rep )
       mView=ViewModelProvider(this,factory).get(ViewModelSub::class.java)
    binding.subView=mView
binding.lifecycleOwner=this
binding.recycler.layoutManager=LinearLayoutManager(this)
mView.msg.observe(this, Observer {
    it.getContentIfNotHandled()?.let {
        Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
    }

})
   acess()



    }
fun acess(){
    mView.getAll().observe(this, Observer {

        binding.recycler.adapter=RecyclerAdapter(it) { sub:Subscriber->itemClick(sub)}


    })

}
    fun itemClick( subscriber: Subscriber){
mView.initUpdateordelete(subscriber)
        Toast.makeText(this,"selected name is ${subscriber.subscriberName}",Toast.LENGTH_LONG).show()    }










}
