package com.androidmads.app_kotlin

import android.graphics.Typeface
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.ajts.androidmads.fontutils.FontUtils

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var typefaceBold: Typeface
    private lateinit var typefaceRegular: Typeface
    private lateinit var typefaceLight: Typeface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init Views
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val textView = findViewById<View>(R.id.textView) as TextView
        val editText = findViewById<View>(R.id.editText) as EditText
        val radioButton = findViewById<View>(R.id.radio) as RadioButton
        val checkBox = findViewById<View>(R.id.chkBox) as CheckBox
        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val viewPager = findViewById<ViewPager>(R.id.viewpager)
        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)

        typefaceBold = Typeface.createFromAsset(assets, lato_bold)
        typefaceLight = Typeface.createFromAsset(assets, lato_light)
        typefaceRegular = Typeface.createFromAsset(assets, lato_regular)

        // Apply Fonts to Toolbar, NavigationView, Views
        val fontUtils = FontUtils()
        fontUtils.applyFontToToolbar(toolbar, typefaceBold)
        fontUtils.applyFontToNavigationView(navigationView, typefaceLight)
        fontUtils.applyFontToView(textView, typefaceRegular)
        fontUtils.applyFontToView(editText, typefaceRegular)
        fontUtils.applyFontToView(radioButton, typefaceBold)
        fontUtils.applyFontToView(checkBox, typefaceLight)
        fontUtils.applyFontToTabLayout(tabLayout, typefaceLight)
        fontUtils.applyFontToRadioGroup(radioGroup, typefaceLight)

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TabFragment(), "ONE")
        adapter.addFragment(TabFragment(), "TWO")
        adapter.addFragment(TabFragment(), "THREE")
        viewPager.adapter = adapter
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        val fontUtils = FontUtils()
        fontUtils.applyFontToMenu(menu, typefaceBold)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else
            super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    companion object {

        var lato_light = "fonts/Lato-Light.ttf"
        var lato_regular = "fonts/Lato-Regular.ttf"
        var lato_bold = "fonts/Lato-Bold.ttf"
    }
}
