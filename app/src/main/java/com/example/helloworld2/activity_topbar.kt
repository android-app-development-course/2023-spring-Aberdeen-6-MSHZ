package com.example.helloworld2

import android.content.AsyncQueryHandler
import android.content.ClipData
import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import android.view.inputmethod.EditorInfo
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ActivityNavigator
import androidx.navigation.findNavController
import com.example.helloworld2.databinding.ActivityTopbarBinding


class activity_topbar : AppCompatActivity() {


    private val searchView: SearchView
        get() = findViewById(R.id.searchView)
    private val listView: ListView
        get() = findViewById(R.id.listView)
    private val button_search: Button
        get() = findViewById(R.id.searchbutton)

    private lateinit var binding:ActivityTopbarBinding

    private lateinit var originalList: ArrayList<String>
    private lateinit var filteredList: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topbar)
        binding = ActivityTopbarBinding.inflate(layoutInflater)
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

        button_search.setOnClickListener{
            val scaleUpAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_up)
            val scaleDownAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_down)

            button_search.startAnimation(scaleUpAnimation)

            Handler().postDelayed({
                button_search.startAnimation(scaleDownAnimation)
            },scaleUpAnimation.duration)
        }
        

        originalList = ArrayList()
        filteredList = ArrayList()

        originalList.add("Item 1")
        originalList.add("Item 2")
        originalList.add("Item 3")
        originalList.add("Item 4")

        val adapter = ArrayAdapter(this,android.R.layout.activity_list_item,filteredList)
        listView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let{ text ->
                    filterList(text)
                }
                return true
            }
        })
    }

    private fun filterList(query: String){
        filteredList.clear()
        originalList.forEach { item ->
            if (item.contains(query, ignoreCase = true)) {
                filteredList.add(item)
            }
        }
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,filteredList)
        listView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.item_1 ->{
//                switchToHome()
//                return true
//            }
//            R.id.item_2 ->{
//                switchToCommunity()
//                return true
//            }
//            R.id.item_3 ->{
//                switchToMyPage()
//                return true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

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




//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.top_app_bar, menu)
//        val menuItem:MenuItem = menu!!.findItem(R.id.edit)
//        mSearchView = MenuItemCompat.getActionView(menuItem) as SearchView
//        mSearchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                Toast.makeText(this@activity_topbar, "点击搜索按钮时触发", Toast.LENGTH_SHORT).show()
//                return false
//            }
//            override fun onQueryTextChange(newText: String?): Boolean {
//                Toast.makeText(this@activity_topbar, "搜索内容改变时触发", Toast.LENGTH_SHORT).show()
//                return false
//            }
//        })
//        return super.onCreateOptionsMenu(menu)
//    }

    fun JumpToList(view: View) {
        val intent = Intent()
        intent.setClass(this@activity_topbar, ListActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left)
    }

    fun JumpTobqj(view: View) {
        val intent = Intent()
        intent.setClass(this@activity_topbar, xiangqingActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left)
    }
}