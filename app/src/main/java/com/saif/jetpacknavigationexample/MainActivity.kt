package com.saif.jetpacknavigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*

import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.lang.Exception
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    //
    private lateinit var navController:NavController
    private lateinit var appBarConfiuration:AppBarConfiguration
    // var bottom:BottomNavigationView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbarMain)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.containerView) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiuration = AppBarConfiguration(setOf(R.id.homeFragment,R.id.settingsFragment,R.id.notificationsFragment)
            //hamborger
        ,drawer_layout_main)


        //toolbarMain.setupWithNavController(navController)
        setupActionBarWithNavController(navController,appBarConfiuration)
       // NavigationUI.setupWithNavController()
        bottom_nav_view.setupWithNavController(navController)
        nav_drawer_main.setupWithNavController(navController)
//   try {
//       bottom_nav_view
//    }catch (e:NullPointerException){
//   println(e.message)
//}

    }

    override fun onSupportNavigateUp(): Boolean {
                                         //تفاعل مع الهمبرقر
        return navController.navigateUp(appBarConfiuration) || super.onSupportNavigateUp()
    }
// خروج ثلاث نقط في البار
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

    return when(item.itemId){
        //about app
        R.id.aboutAppFragment ->{
            val action = MainNavGraphDirections.actionGlobalAboutAppFragment()
            navController.navigate(action)
            return true
        }else -> item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        //return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    }
    //ثلاث نقط البار
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)

    }
}