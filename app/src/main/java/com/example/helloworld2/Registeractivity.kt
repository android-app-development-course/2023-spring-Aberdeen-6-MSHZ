package com.example.helloworld2

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContentInfo
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.delay


class Registeractivity : AppCompatActivity() {

    private val register_username: TextInputEditText
        get() = findViewById(R.id.username_register)

    private val register_psw: TextInputEditText
        get() = findViewById(R.id.psw_register)

    private val register_psw_again: TextInputEditText
        get() = findViewById(R.id.psw_register_again)

    private val register_button: Button
        get() = findViewById(R.id.enter1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeractivity)
        val dbHelper = Logindatabasehelper(this,"user_account.db",1)
        val db = dbHelper.writableDatabase

        register_button.setOnClickListener{
            val r_username = register_username.text.toString().trim()
            val r_psw = register_psw.text.toString().trim()
            val r_psw_a = register_psw_again.text.toString().trim()

            val values=ContentValues()

//            if(r_username.isEmpty()||r_psw.isEmpty()||r_psw_a.isEmpty()&&r_psw == r_psw_a){
            if(r_psw == r_psw_a&& r_psw.isNotEmpty()){
                val values1=ContentValues().apply {
                    put("username",r_username)
                    put("userpassword",r_psw)
                }
                db.insert("Account",null,values1)
                Toast.makeText(this, "Register successfully", Toast.LENGTH_LONG).show()

                val intent = Intent()
                intent.setClass(this@Registeractivity, MainActivity::class.java)
                startActivity(intent)
            }
            if(r_psw != r_psw_a){
                Toast.makeText(this, "Please input the same password", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Please fill in all form fields", Toast.LENGTH_LONG).show()
            }
        }
    }


    fun JumpToLogin(view: View) {
        val intent = Intent()
        intent.setClass(this@Registeractivity, MainActivity::class.java)
        startActivity(intent)
    }
}