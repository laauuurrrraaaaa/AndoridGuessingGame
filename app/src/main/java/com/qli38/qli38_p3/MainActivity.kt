package com.qli38.qli38_p3

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.preference.PreferenceManager
import com.qli38.qli38_p3.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private val prefs: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.naveHost_fragment) as NavHostFragment
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController)

        if (savedInstanceState == null) {
            if (prefs.getBoolean(SHOW_MESSAGE_AT_START, false)) {
                welcomeAlert()
            }
        }

    }

    override fun onSupportNavigateUp() = Navigation.findNavController(this, R.id.naveHost_fragment).navigateUp()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.newLink_menuItem -> {
                navHostFragment.navController.navigate(R.id.action_mainFragment_to_webviewFragment)
                true
            }
            R.id.settings_menuItem -> {
                navHostFragment.navController.navigate(R.id.action_mainFragment_to_settingFragment)
                true
            }
            R.id.info_menuItem -> {
                navHostFragment.navController.navigate(R.id.action_mainFragment_to_infoFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun welcomeAlert() {
        val msg = resources.getString(R.string.welcome_title)
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle(R.string.welcome)
            setMessage(msg)
//            setIcon(R.drawable.splash_img)
            setPositiveButton(R.string.yes, null)
            show()
        }
    }

    companion object {
        const val SHOW_MESSAGE_AT_START = "show_message_at_start"
        const val SHOW_HIDDEN_IMAGE = "show_hidden_image"
        const val EFFECT_SELECTION = "effect_selection"
    }
}