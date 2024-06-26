package com.tuk.ddhi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {
    private lateinit var mFirebaseAuth: FirebaseAuth
    private lateinit var mDatabaseRef: DatabaseReference
    private lateinit var mEtEmail: EditText
    private lateinit var mEtPwd: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mFirebaseAuth = FirebaseAuth.getInstance()

        mEtEmail = findViewById(R.id.et_email)
        mEtPwd = findViewById(R.id.et_pwd)

        var btn_login = findViewById<Button>(R.id.btn_login)
        btn_login.setOnClickListener {
            var strEmail: String = mEtEmail.getText().toString()
            var strPwd: String = mEtPwd.getText().toString()

            mFirebaseAuth.signInWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(this)
            { task ->

                if(task.isSuccessful()) {
                    // firebase 연동이 안되서인지 모르겠으나 다시 main activity로 돌아오는 오류 존재
                    var intent: Intent = Intent(this, BottomActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "로그인 실패!", Toast.LENGTH_SHORT).show()
                }

            }

        }
        var btn_register = findViewById<Button>(R.id.btn_register)
        btn_register.setOnClickListener {
            var intent: Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}