package com.codinginflow.navigationcomponenttutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_welcome.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class WelcomeFragment : Fragment() {

    // creating the instance of the args so as to recieve data passed from the login fragment
    private val args: WelcomeFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // assigning the data recieved from the login fragment to the username and password
        text_view_username.text = args.username
        text_view_password.text = args.password

        // the ok button is used to navigate to home fragments
        button_ok.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToHomeragment()
            findNavController().navigate(action)
        }
    }
}
