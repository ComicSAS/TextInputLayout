package com.example.textinputlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.text.Editable
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var onSubmitAction: View.OnClickListener
    private lateinit var onNameAction: View.OnClickListener
    private lateinit var onSurnameAction: View.OnClickListener
    private lateinit var onAgeAction: View.OnClickListener
    private lateinit var onAnotherAction: View.OnClickListener

    private lateinit var user: User
    private lateinit var userName: String
    private lateinit var userSurname: String
    private lateinit var userAnother: String
    var userAge: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUser()
        initViews()
        initListeners()
        bindListeners()
    }

    private fun initViews() {
        etMainName.setText(user.name)
        etMainSurname.setText(user.surname)
        etMainAge.setText(user.age.toString())
        etMainAnother.setText(user.another)
    }

    private fun initUser() {
        user = User("Andrew", "Sukhovolskij")
        userName = user.name
        userSurname = user.surname
        userAge = user.age.toString().toInt()
        userAnother = user.another.toString()
    }

    private fun initListeners() {
        onNameAction = View.OnClickListener {
            if (isAllETsValid(etMainName, etMainSurname))
                btnMainSubmit.setEnabled(true)
            else {
                makeToast("onNameAction: Error(Too short Name or Surname)")
                btnMainSubmit.setEnabled(false)
            }
        }

        onSurnameAction = View.OnClickListener {
            if (isAllETsValid(etMainName, etMainSurname))
                btnMainSubmit.setEnabled(true)
            else {
                makeToast("onSurnameAction: Error(Too short Name or Surname)")
                btnMainSubmit.setEnabled(false)
            }
        }

        onAgeAction = View.OnClickListener {
            if (isAllETsValid(etMainName, etMainSurname))
                btnMainSubmit.setEnabled(true)
            else {
                makeToast("onAgeAction: Error(Too short Name or Surname)")
                btnMainSubmit.setEnabled(false)
            }
        }

        onAnotherAction = View.OnClickListener {
            if (isAllETsValid(etMainName, etMainSurname))
                btnMainSubmit.setEnabled(true)
            else {
                makeToast("onAnotherAction: Error(Too short Name or Surname)")
                btnMainSubmit.setEnabled(false)
            }
        }

        onSubmitAction = View.OnClickListener {
            userName = etMainName.text.toString()
            userSurname = etMainSurname.text.toString()
            userAge = etMainAge.text.toString().toInt()
            userAnother = etMainAnother.text.toString()

            if (isAllViewWithContent(userName, userSurname)) {
                user.name = userName
                user.surname = userSurname
                user.age = userAge
                user.another = userAnother
                makeToast(
                    """onSubmitAction:
                    |User Name = ${user.name}
                    |User Surname = ${user.surname}
                    |User Age = ${user.age}
                    |User Another = ${user.another}
                """.trimMargin()
                )
            } else {
                makeToast("onSubmitAction: Error(Too short Name or Surname)")
                btnMainSubmit.setEnabled(false)
            }
        }
    }

    private fun bindListeners() {
        btnMainSubmit.setOnClickListener(onSubmitAction)
        etMainName.setOnClickListener(onNameAction)
        etMainSurname.setOnClickListener(onSurnameAction)
        etMainAge.setOnClickListener(onAgeAction)
        etMainAnother.setOnClickListener(onAnotherAction)
    }


    private fun isValid(str: String): Boolean {
        return str.length > 2
    }

    private fun isAllViewWithContent(str1: String, str2: String): Boolean {
        return isValid(str1) && isValid(str2)
    }

    private fun isETValid(et: TextInputEditText): Boolean {
        return et.length() > 2
    }

    private fun isAllETsValid(et1: TextInputEditText, et2: TextInputEditText): Boolean {
        return isETValid(et1) && isETValid(et2)
    }

    private fun makeToast(msg: String) {
        Toast.makeText(this, "click " + msg, Toast.LENGTH_LONG).show()
    }
}
