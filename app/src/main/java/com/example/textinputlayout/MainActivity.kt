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

    var user = User("Andrew", "Sukhovolskij")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etMainName.setText(user.name)
        etMainSurname.setText(user.surname)
        etMainAge.setText(user.age.toString())
        etMainAnother.setText(user.another)

        initListeners()
        bindListeners()
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
            val name = etMainName.text.toString()
            val surname = etMainSurname.text.toString()
            val age = etMainAge.text.toString().toInt()
            val another = etMainAnother.text.toString()

            if (isAllViewWithContent(name, surname)) {
                user.name = name
                user.surname = surname
                user.age = age
                user.another = another
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

    private fun makeToast(msg: String) {
        Toast.makeText(this, "click " + msg, Toast.LENGTH_LONG).show()
    }
}
