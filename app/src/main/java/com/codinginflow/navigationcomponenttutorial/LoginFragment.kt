package com.codinginflow.navigationcomponenttutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // the login button is used to navigate to the login fragment
        // using navigation component also handles backStack automatically
        /*to pass arguments between fragments we need to specify the argument types in the nav graph
        * this is done on the destination fragment we are sending the data to and then rebuild the project so that the compiler generates the necessary code*/
        button_confirm.setOnClickListener {
            val username = edit_text_username.text.toString()
            val password = edit_text_password.text.toString()

            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(username, password)
            findNavController().navigate(action)
        }
    }
}
