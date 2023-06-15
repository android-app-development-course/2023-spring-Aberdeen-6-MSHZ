package com.example.helloworld2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import java.text.FieldPosition

class CustomAdapter(private val originalList: List<String>):BaseAdapter() {
    private var filteredList: List<String> = originalList

    override fun getCount(): Int {
        return filteredList.size
    }

    override fun getItem(position: Int): Any {
        return filteredList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return convertView ?:LayoutInflater.from(parent?.context).inflate(
            R.layout.activity_topbar,
            parent,
            false
        )
    }

    fun filter(query:String){
        filteredList = originalList.filter { it.contains(query,ignoreCase = true) }
        notifyDataSetChanged()
    }

}