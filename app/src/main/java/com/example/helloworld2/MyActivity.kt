package com.example.helloworld2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld2.My_Adaptor
import com.example.helloworld2.R
import com.example.helloworld2.databinding.ActivityMyBinding
import com.example.helloworld2.databinding.ActivityTopbarBinding


class MyActivity : AppCompatActivity() {

    private val myList = ArrayList<My_Adaptor.Mylist>()

    private lateinit var binding:ActivityMyBinding


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        binding = ActivityMyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.bottomNavigation.setOnNavigationItemReselectedListener { menuItem->
            when(menuItem.itemId){
                R.id.item_1 ->{
                    switchToHome()
                }
                R.id.item_2 ->{
                    switchToCommunity()
                }
                R.id.item_3 ->{
                    switchToMyPage()
                }
            }
        }


        findViewById<TextView>(R.id.Myname).text=intent?.getStringExtra("data")


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        initLists()

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        val adapter = My_Adaptor(myList)
        recyclerView.adapter = adapter
    }

    private fun initLists() {
        myList.add(My_Adaptor.Mylist(R.drawable.my_account_1, "账号",R.drawable.right))
        myList.add(My_Adaptor.Mylist(R.drawable.my_likes_5, "点赞",R.drawable.right))
        myList.add(My_Adaptor.Mylist(R.drawable.my_collections_3,"收藏",R.drawable.right))
        myList.add(My_Adaptor.Mylist(R.drawable.my_dairy_4, "动态",R.drawable.right))
        myList.add(My_Adaptor.Mylist(R.drawable.my_setting_6, "设置",R.drawable.right))

    }

    private fun switchToHome(){
        val intent = Intent()
        intent.setClass(this, activity_topbar::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
    }

    private fun  switchToCommunity(){
        val intent = Intent()
        intent.setClass(this, communityActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
    }

    private fun  switchToMyPage(){
        val intent = Intent()
        intent.setClass(this, MyActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
    }

}
