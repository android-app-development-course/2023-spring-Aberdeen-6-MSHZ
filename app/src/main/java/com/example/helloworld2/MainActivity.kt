package com.example.helloworld2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.romainpiel.shimmer.Shimmer
import com.romainpiel.shimmer.ShimmerTextView

class MainActivity : AppCompatActivity() {

    private val loginbutton: Button
        get() = findViewById(R.id.enter)

    private val usernameinput: TextInputEditText
        get() = findViewById(R.id.username)

    private val pswinput: TextInputEditText
        get() = findViewById(R.id.psw)

    private val forgetpsw: TextView
        get() = findViewById(R.id.forgetpsw)

    private val register: TextView
        get() = findViewById(R.id.register)
    
    private val text1: ShimmerTextView
        get() = findViewById(R.id.appname)

    lateinit var tv: ShimmerTextView

    lateinit var shimmer:Shimmer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper=Logindatabasehelper(this,"user_account.db",1)
        val db = dbHelper.writableDatabase
        var n = 0



        loginbutton.setOnClickListener {


            val username = usernameinput.text.toString().trim()
            val psw = pswinput.text.toString().trim()
            var flag = 0
            n += 1

            val cursor = db.query("Account",null,null,null,null,null,null)
            if(cursor.moveToFirst()){
                do{
                    val username1 = cursor.getString(cursor.getColumnIndexOrThrow("username"))
                    val userpassword1 = cursor.getString(cursor.getColumnIndexOrThrow("userpassword"))

                    if(username==username1 && psw==userpassword1){
                        flag = 1
                        val intent = Intent(this,activity_topbar::class.java)
                        intent.putExtra("data",""+ usernameinput.text.toString())
                        startActivity(intent)
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
                        Toast.makeText(this, "Login succeed", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "welcome "+ usernameinput.text.toString(), Toast.LENGTH_LONG).show()
                        break
                    }
                    if(username.isEmpty() || psw.isEmpty()){
                        flag = 2
                        Toast.makeText(this, "Please fill in all form fields", Toast.LENGTH_LONG).show()
                        break
                    }
                }while(cursor.moveToNext())
                if(flag==0){
                    Toast.makeText(this, "Please sign up first.Come to the sign up page", Toast.LENGTH_LONG).show()
                }
            }
            cursor.close()
            if(flag!=1&&n==1){
                Toast.makeText(this, "You have 2 more attempts to log in", Toast.LENGTH_LONG).show()
            }
            if(flag!=1&&n==2){
                Toast.makeText(this, "You have 1 more attempts to log in", Toast.LENGTH_LONG).show()
            }
            if(flag!=1&&n==3){
                Toast.makeText(this, "You can not log in now", Toast.LENGTH_LONG).show()
                n = 0
                loginbutton.isEnabled = false
                loginbutton.setBackgroundColor(Color.parseColor("#CDCDCD"))

            }
        }
    }

    fun JumpToRegister(view: View) {
        val intent = Intent()
        intent.setClass(this@MainActivity, Registeractivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)

    }

    fun JumpToForgetPsw(view: View) {
        val intent = Intent()
        intent.setClass(this@MainActivity, ForgetPswactivity::class.java)
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
    }

//    fun toggleanimation(view: View){
//
//    }
}