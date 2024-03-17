package com.example.laba4mobile1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var users : Array<User>
    private lateinit var login : EditText
    private lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        login = findViewById(R.id.loginText)
        password = findViewById(R.id.editTextTextPassword)

        users = arrayOf(
            User("admin","admin","Админ сервиса"),
            User("user1","1234","Системный админ сервиса"),
            User("user2","user2","user2 - данного сервиса"),
            User("user3","user3","user3 - данного сервиса"),
            User("user4","user4","user4 - данного сервиса"),
            )
    }

    fun loginButtonPress(v : View){
        var a : Boolean = false
        if (login.text.toString() != "" && password.text.toString() != ""){
            for (user in users) {
                if (login.text.toString() == user.login && password.text.toString() == user.password) {
                    val intent = Intent(this, DataActivity::class.java)
                    intent.putExtra("user", user)
                    startActivity(intent)
                    a = true
                }
            }
            if (!a)12
                Toast.makeText(this, "Не правильно введен логин или пароль", Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(this, "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show()

    }
}