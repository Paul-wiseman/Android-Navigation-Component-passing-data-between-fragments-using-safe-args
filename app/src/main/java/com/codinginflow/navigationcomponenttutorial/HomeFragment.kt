package com.codinginflow.navigationcomponenttutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_homeragment.*

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homeragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // the login button is used to navigate to the login fragment
        // using navigation component also handles backStack automatically
        button_login.setOnClickListener {

            // the action indicates the direction of navigation
            val action = HomeFragmentDirections.actionHomeragmentToLoginFragment()
            findNavController().navigate(action) // calling the navigate method on the navController passing in the action
        }
    }
}
