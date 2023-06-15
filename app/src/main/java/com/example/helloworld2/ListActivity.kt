package com.example.helloworld2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import android.content.Intent
import android.widget.AdapterView
import android.widget.ListView

class ListActivity : AppCompatActivity() {
    private val onePieceList = ArrayList<ImageListArray>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        addingData() //初始化数据

        //创建适配器，在适配器中导入数据 1.当前类 2.list_view一行的布局 3.数据集合
        val imageListAdapter = ImageListAdapter(this, R.layout.image_list, onePieceList)
        val listView = findViewById<ListView>(R.id.ImageListView) //将适配器导入Listview
        listView.adapter = imageListAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            when(position){
                0 -> {
                    val intent = Intent()
                    intent.setClass(this, xiangqingActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left)
                }
            }
        }

    }

    /*
    导入数据
     */
    private fun addingData() {
        val ace = ImageListArray("白切鸡", R.drawable.baiqieji)
        onePieceList.add(ace)
        val arlong = ImageListArray("煲仔饭", R.drawable.baozaifan)
        onePieceList.add(arlong)
        val barbe_blanche = ImageListArray("肠粉", R.drawable.changfen)
        onePieceList.add(barbe_blanche)
        val baroque_works = ImageListArray("姜撞奶", R.drawable.jiangzhuangnai)
        onePieceList.add(baroque_works)
        val shaoe_works = ImageListArray("烧鹅", R.drawable.shaoe)
        onePieceList.add(shaoe_works)
    }
}