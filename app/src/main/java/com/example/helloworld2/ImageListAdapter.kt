package com.example.helloworld2

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes

class ImageListAdapter(context: Context, @LayoutRes private val resourceId: Int, objects: List<ImageListArray>)
    : ArrayAdapter<ImageListArray>(context, resourceId, objects) {

    /*
    为什么要重写getView？因为适配器中其实自带一个返回布局的方法，
    这个方法可以是自定义适配一行的布局显示，因为我们需要更复杂的布局内容，
    所以我们直接重写它，，不需要在导入一个简单的TextView或者ImageView布局让适配器在写入布局数据。
    所以在recourceId自定义布局id直接导入到getView里面，getView方法不在convertView中获取布局了。
    最后只要返回一个view布局就可以。
     */
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val imageListArray = getItem(position) //得到集合中指定位置的一组数据，并且实例化
        val view = LayoutInflater.from(context).inflate(resourceId, parent, false) //用布局裁剪器(又叫布局膨胀器)，将导入的布局裁剪并且放入到当前布局中

        val imageView = view.findViewById<ImageView>(R.id.IamgeView_List) //从裁剪好的布局里获取ImageView布局ID
        val textView = view.findViewById<TextView>(R.id.TextView_List) //从裁剪好的布局里获取TextView布局Id
        textView?.text = imageListArray?.getName()
        imageListArray?.getImageId()?.let { imageView?.setImageResource(it) }
        imageListArray?.getImageId()?.let { imageView?.setImageResource(it) } //将当前一组imageListArray类中的图片iamgeId导入到ImageView布局中

        return view
    }
}