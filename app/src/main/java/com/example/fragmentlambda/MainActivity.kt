package com.example.fragmentlambda

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private lateinit var edtUsername:TextView
    private lateinit var edtFirstName:TextView
    private lateinit var edtLastName:TextView
    private lateinit var edtEmail:TextView
    private lateinit var edtPassword:TextView
    private lateinit var edtPhone:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edtUsername = findViewById<TextView>(R.id.edtUsernameActivity)
        edtFirstName = findViewById<TextView>(R.id.edtFirtsNameActivity)
        edtLastName = findViewById<TextView>(R.id.edtLastNameActivity)
        edtEmail = findViewById<TextView>(R.id.edtEmailActivity)
        edtPassword = findViewById<TextView>(R.id.edtPasswordActivity)
        edtPhone = findViewById<TextView>(R.id.edtPhoneActivity)

        val accountFragment = AccountFragment.newInstance(response)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.frameLayout, accountFragment)
        }
    }

    val response:(Usuario) -> Unit = { user ->
        edtUsername.text = user.userName.toString()
        edtFirstName.text = user.firstName.toString()
        edtLastName.text = user.lastName.toString()
        edtEmail.text = user.email.toString()
        edtPassword.text = user.password.toString()
        edtPhone.text = user.phone.toString()
    }
}