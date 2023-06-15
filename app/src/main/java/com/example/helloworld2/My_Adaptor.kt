package com.example.helloworld2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class My_Adaptor(val myList:List<Mylist>): RecyclerView.Adapter<My_Adaptor.ViewHolder>(){

    class Mylist(var imageId: Int, var name: String, var imagesId: Int)


    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val mylistimage: ImageView =view.findViewById(R.id.MyListImage)
        val mylistname: TextView =view.findViewById(R.id.MyListName)
        val mylistturn: ImageView =view.findViewById(R.id.MyListTurn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.mylist_items,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myList=myList[position]
        holder.mylistimage.setImageResource(myList.imageId)
        holder.mylistname.text=myList.name
        holder.mylistturn.setImageResource(myList.imagesId)
    }
    override fun getItemCount(): Int {
        return myList.size
    }

}
