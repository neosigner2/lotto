package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_test.*
class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        button3.setOnClickListener{
            val intent = Intent(this@TestActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }
    fun goMainPage(view:View){
        val intent = Intent(this@TestActivity, MainActivity::class.java)
        startActivity(intent)
    }
}
