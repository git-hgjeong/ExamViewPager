package com.example.examviewpager

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.examviewpager.ui.dialog.PayDialogFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val btnComm: Button = findViewById(R.id.btnComm)
        btnComm.setOnClickListener {
            val msg1 : String = navView.selectedItemId.toString()

            val args = Bundle()
            args.putString("param1", "parameter test.")

            val dialog = PayDialogFragment()
            dialog.setStyle( DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_NoTitleBar_Fullscreen );
            dialog.show(supportFragmentManager, "dialog");
            dialog.arguments = args
        }
    }
}