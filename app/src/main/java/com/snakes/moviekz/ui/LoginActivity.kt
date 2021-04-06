package com.snakes.moviekz.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.snakes.moviekz.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        register_tv.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        login_btn.setOnClickListener {
            when {
                TextUtils.isEmpty(email_et.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this,
                        "Enter email",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(password_et.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this,
                        "Enter passord",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    val email: String = email_et.text.toString().trim { it <= ' ' }
                    val password: String = password_et.text.toString().trim { it <= ' ' }

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful){
                                val firebaseUser:FirebaseUser = task.result!!.user!!

                                Toast.makeText(
                                    this,
                                    "You were loggen in succesfully!!!",
                                    Toast.LENGTH_SHORT
                                ).show()

                                val intent = Intent(this, MainActivity::class.java)
                                intent.apply {
                                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    putExtra("user_id",FirebaseAuth.getInstance().currentUser!!.uid)
                                    putExtra("email_id",email)
                                }
                                startActivity(intent)
                                finish()
                            }else{
                                Toast.makeText(
                                    this,
                                    task.exception?.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
        }

    }
}