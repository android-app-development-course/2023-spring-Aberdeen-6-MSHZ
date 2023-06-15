package com.example.helloworld2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class xiangqingActivity : AppCompatActivity() {
    private val back_botton: Button
        get() = findViewById(R.id.r_button)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xiangqing)
        val heartImageView: ImageView = findViewById(R.id.heartImageView)
        var isLiked = false

        back_botton.setOnClickListener{
            val intent = Intent()
            intent.setClass(this, ListActivity::class.java)
            startActivity(intent)
        }

        heartImageView.setOnClickListener{
            if (isLiked) {
                heartImageView.setImageResource(R.drawable.heartfirst) // 设置空心爱心图标
                isLiked = false // 更新状态为未点击
            } else {
                heartImageView.setImageResource(R.drawable.heartfull) // 设置实心爱心图标
                isLiked = true // 更新状态为已点击
            }
        }
    }
}