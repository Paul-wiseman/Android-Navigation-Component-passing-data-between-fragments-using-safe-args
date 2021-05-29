package com.codinginflow.navigationcomponenttutorial

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // creating the appbar configuration object
    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        // the appBarConfiguration helps to display the name of the current fragment being displayed in the appbar
        // adding the drawer layout makes the hamburger icon visible
        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.searchFragment), drawer_layout)

        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // connecting the bottom navigation view with the nav graph
        bottom_nav.setupWithNavController(navController)

        // setting the navigation drawer
        nav_view.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.termsAndConditions) {
            val action = NavGraphDirections.actionGlobalTermsFragment()
            navController.navigate(action)
            true
        } else {

            return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }
    }
}
