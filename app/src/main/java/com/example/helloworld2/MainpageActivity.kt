package com.example.helloworld2

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainpageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainpage)


//        if(Intent.ACTION_SEARCH == intent.action){
//            intent.getStringExtra(SearchManager.QUERY)?.also { query -> doMySearch(query) }
//        }
    }
}