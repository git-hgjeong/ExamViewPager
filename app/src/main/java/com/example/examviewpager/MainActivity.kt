package com.example.examviewpager

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.examviewpager.ui.dashboard.DashboardFragment
import com.example.examviewpager.ui.dialog.PayDialogFragment
import com.example.examviewpager.ui.dialog.SendDialogFragment
import com.example.examviewpager.ui.home.HomeFragment
import com.example.examviewpager.ui.notifications.NotificationsFragment
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

            val selectedItemId: Int = navView.getSelectedItemId()
            val selectedItem: MenuItem = navView.getMenu().findItem(selectedItemId)
            val menuTitle = selectedItem.title.toString()

            val args = Bundle()
            args.putString("param1", menuTitle)

            val fragment : Fragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as Fragment
            for(childFragment: Fragment in fragment.childFragmentManager.fragments) {
                if(childFragment is HomeFragment) {
                    Log.d("==>", "1")
                    val fm = childFragment as HomeFragment
                    val str: String = fm.getCardinfo()
                    Log.d("Get:", str)
                    openSendDialog(args)
                }else if(childFragment is NotificationsFragment){
                    val fm = childFragment as NotificationsFragment
                    val str: String = fm.getAmount()
                    Log.d("Get:", str)
                    if(str != ""){
                        args.putString("amount", str)
                        openSendDialog(args)
                    }
                }else if(childFragment is DashboardFragment){
                    val fm = childFragment as DashboardFragment
                    Log.d("==>","DashboardFragment")
                    openSendDialog(args)
                }else{
                    Log.d("==>","2")
                }
            }


        }
    }

    fun openSendDialog(args:Bundle){
        val dialog = SendDialogFragment()
        dialog.setStyle( DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_NoTitleBar_Fullscreen );
        dialog.show(supportFragmentManager, "dialog");
        dialog.arguments = args
    }
}