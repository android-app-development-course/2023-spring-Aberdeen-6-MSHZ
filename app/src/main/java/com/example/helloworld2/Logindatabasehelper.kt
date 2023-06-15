package com.example.helloworld2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class Logindatabasehelper(private val context: Context, name:String, version:Int):SQLiteOpenHelper(context,name,null,version) {
    private val create_user_account = "create table Account(" +
            "username," +
            "userpassword)"

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(create_user_account)
        Toast.makeText(context,"create succeeded",Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        if (p0 != null) {
            p0.execSQL("drop table if exists Account")
            onCreate(p0)
        }
    }

}