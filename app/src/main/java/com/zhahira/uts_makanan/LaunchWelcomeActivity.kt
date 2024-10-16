package com.zhahira.uts_makanan

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LaunchWelcomeActivity : AppCompatActivity() {
    private lateinit var btnlogin : Button
    private lateinit var btnsignup : Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_launch_welcome)

        btnlogin = findViewById(R.id.btnLogIn)
        btnsignup = findViewById(R.id.btnSignUp)

        btnlogin.setOnClickListener(){
            val intent = Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }

        btnsignup.setOnClickListener(){
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}