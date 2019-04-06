package com.example.textinputlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var user = User("Andrew", "Sukhovolskij")
        etMainName.setText(user.name)
        etMainSurname.setText(user.surname)
        etMainAge.setText(user.age.toString())
        etMainAnother.setText(user.another)
    }
}
