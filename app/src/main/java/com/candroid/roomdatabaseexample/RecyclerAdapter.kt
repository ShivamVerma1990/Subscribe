package com.candroid.roomdatabaseexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.candroid.roomdatabaseexample.databinding.ListItemBinding
import com.candroid.roomdatabaseexample.db.Subscriber

class RecyclerAdapter(
    val item: List<Subscriber>,
    val cliclListener: (Subscriber) -> Unit
):RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

class RecyclerViewHolder(private val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root){
fun bind(subscriber: Subscriber,cliclListener: (Subscriber) -> Unit){
    binding.nameTextView.text=subscriber.subscriberName
binding.emailTextView.text=subscriber.subscriberEmail
binding.listItemLayout.setOnClickListener {
    cliclListener(subscriber)
}

}

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
   val layoutInflater=LayoutInflater.from(parent.context)
val binding:ListItemBinding=DataBindingUtil.inflate(layoutInflater,R.layout.list_item,parent,false)
return RecyclerViewHolder(binding)

    }

    override fun getItemCount(): Int {
return item.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
holder.bind(item[position],cliclListener)
    }

}
