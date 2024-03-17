package com.example.laba4mobile1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DataActivity : AppCompatActivity() {
    private lateinit var username : TextView
    private lateinit var data : TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        username = findViewById(R.id.usernameText)
        data = findViewById(R.id.dataText)

        val user = intent.getParcelableExtra<User>("user")
        if (user != null) {
            username.text = user.login
            data.text = user.data
        }
    }

    fun backButtonPress(v : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}