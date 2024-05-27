package com.example.fragmentlambda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_account, container, false)
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        val edtUserName = view.findViewById<EditText>(R.id.edtUsernameFragment)
        val edtFirstName = view.findViewById<EditText>(R.id.edtFirtsNameFragment)
        val edtLastName = view.findViewById<EditText>(R.id.edtLastNameFragment)
        val edtEmail = view.findViewById<EditText>(R.id.edtEmailFragment)
        val edtPassword = view.findViewById<EditText>(R.id.edtPasswordFragment)
        val edtPhone = view.findViewById<EditText>(R.id.edtPhoneFragment)
        val btnAcceptFragment = view.findViewById<Button>(R.id.btnAcceptFragment)

        btnAcceptFragment.setOnClickListener{
            val userName = edtUserName.text.toString()
            val firstName = edtFirstName.text.toString()
            val lastName = edtLastName.text.toString()
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            val phone = edtPhone.text.toString()

            val usuario = Usuario(userName, firstName, lastName, email, password, phone)
            onRegistroCompleted?.invoke(usuario) // asegura que el objeto no sea nulo => ?
        }
        return view
    }

    companion object {
        private lateinit var onRegistroCompleted: (Usuario) -> Unit
        @JvmStatic
        fun newInstance(onRegistroCompleted:(Usuario) -> Unit): AccountFragment{
            val accountFragment = AccountFragment()
            this.onRegistroCompleted = onRegistroCompleted
            return accountFragment
        }
    }
}